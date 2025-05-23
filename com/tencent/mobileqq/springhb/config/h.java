package com.tencent.mobileqq.springhb.config;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.biz.m;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$DeviceInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$PageReqInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$PageRespInfo;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$ReqGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$RespGetConfigByPage;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService$Screen;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.portal.o;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.springhb.api.ISpringHbReportApi;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.fh;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.zip.InflaterInputStream;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import mqq.app.Packet;
import org.apache.http.util.ByteArrayBuffer;

/* compiled from: P */
/* loaded from: classes18.dex */
public class h extends m {
    static IPatchRedirector $redirector_;

    public h() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    private void a(Intent intent) {
        if (intent != null) {
            int intExtra = intent.getIntExtra("k_req_occasion", 0);
            int intExtra2 = intent.getIntExtra("k_version", -1);
            int intExtra3 = intent.getIntExtra("k_peak_version", -1);
            QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("handleGetConfigFail reqOccasion=%s reqVersion=%s reqPeakVersion=%s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Integer.valueOf(intExtra3)));
            ((g) ((QQAppInterface) getAppRuntime()).getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER)).y(false, false, intExtra2, intExtra3, 0, null, null, intExtra, false, 0L);
        }
    }

    private byte[] b(byte[] bArr) {
        InflaterInputStream inflaterInputStream;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inflaterInputStream = new InflaterInputStream(new ByteArrayInputStream(bArr));
        } catch (Throwable th5) {
            th = th5;
            inflaterInputStream = null;
        }
        try {
            byte[] bArr2 = new byte[256];
            while (true) {
                int read = inflaterInputStream.read(bArr2);
                if (-1 == read) {
                    break;
                }
                byteArrayOutputStream.write(bArr2, 0, read);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            try {
                inflaterInputStream.close();
            } catch (Throwable th6) {
                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "inflate fail", th6);
            }
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th7) {
                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "inflate fail", th7);
            }
            return byteArray;
        } catch (Throwable th8) {
            th = th8;
            try {
                QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, "inflate fail.", th);
                if (inflaterInputStream != null) {
                    try {
                        inflaterInputStream.close();
                    } catch (Throwable th9) {
                        QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "inflate fail", th9);
                    }
                }
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th10) {
                    QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "inflate fail", th10);
                }
                return null;
            } finally {
            }
        }
    }

    private void c(Intent intent, boolean z16, boolean z17) {
        boolean z18;
        if (z17 || z16) {
            if (z17) {
                try {
                    int intExtra = intent.getIntExtra("k_retry", 0);
                    int i3 = intExtra + 1;
                    if (intExtra < 1) {
                        intent.putExtra("k_retry", i3);
                        getAppRuntime().startServlet((NewIntent) intent);
                        z18 = true;
                        QLog.d("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG doRetry=%b isFallbackFail=%b", Boolean.valueOf(z18), Boolean.valueOf(z16)));
                        if (z18 && z16) {
                            a(intent);
                            return;
                        }
                    }
                } catch (Exception e16) {
                    AppRuntime peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                    if (peekAppRuntime != null) {
                        ((ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all")).reportExCatch(304, e16, new String[0]);
                    }
                    QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive fail." + e16.getMessage(), e16);
                    return;
                }
            }
            z18 = false;
            QLog.d("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG doRetry=%b isFallbackFail=%b", Boolean.valueOf(z18), Boolean.valueOf(z16)));
            if (z18) {
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:66:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x02f7  */
    /* JADX WARN: Type inference failed for: r12v1 */
    /* JADX WARN: Type inference failed for: r12v10 */
    /* JADX WARN: Type inference failed for: r12v11 */
    /* JADX WARN: Type inference failed for: r12v15 */
    /* JADX WARN: Type inference failed for: r12v16 */
    /* JADX WARN: Type inference failed for: r12v17 */
    /* JADX WARN: Type inference failed for: r12v18 */
    /* JADX WARN: Type inference failed for: r12v2 */
    /* JADX WARN: Type inference failed for: r12v22 */
    /* JADX WARN: Type inference failed for: r12v23 */
    /* JADX WARN: Type inference failed for: r12v27 */
    /* JADX WARN: Type inference failed for: r12v9 */
    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onReceive(Intent intent, FromServiceMsg fromServiceMsg) {
        ?? r122;
        boolean z16;
        int i3;
        AppRuntime peekAppRuntime;
        boolean z17;
        ConfigurationService$PageRespInfo configurationService$PageRespInfo;
        int length;
        boolean z18;
        int i16;
        byte[] buffer;
        int i17;
        ?? r123;
        boolean z19;
        ArrayList arrayList;
        boolean z26;
        int i18;
        boolean z27;
        ArrayList arrayList2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) intent, (Object) fromServiceMsg);
            return;
        }
        if (QLog.isColorLevel()) {
            QLog.d("SpringHb_SpringHbEntranceConfigServlet", 2, "-->\u5165\u53e3\u914d\u7f6e\u8bf7\u6c42\u56de\u5305 response.isSuccess() = " + fromServiceMsg.isSuccess());
        }
        int intExtra = intent.getIntExtra("k_cmd", -1);
        boolean z28 = false;
        intent.getIntExtra("k_id", 0);
        intent.getIntExtra("k_version", -1);
        long longExtra = intent.getLongExtra("key_req_adcode", 0L);
        boolean z29 = true;
        if (fromServiceMsg.isSuccess()) {
            try {
                byte[] a16 = fh.a(fromServiceMsg.getWupBuffer());
                if (intExtra != 1) {
                    z29 = false;
                } else {
                    QQAppInterface qQAppInterface = (QQAppInterface) getAppRuntime();
                    if (qQAppInterface == null) {
                        return;
                    }
                    g gVar = (g) qQAppInterface.getManager(QQManagerFactory.SPRING_FESTIVAL_RED_PACKET_MANAGER);
                    ConfigurationService$RespGetConfigByPage configurationService$RespGetConfigByPage = new ConfigurationService$RespGetConfigByPage();
                    configurationService$RespGetConfigByPage.mergeFrom(a16);
                    int i19 = configurationService$RespGetConfigByPage.result.get();
                    int i26 = configurationService$RespGetConfigByPage.type.get();
                    QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("onReceive CMD_GET_CONFIG result=%s type=%s", Integer.valueOf(i19), Integer.valueOf(i26)));
                    if (i19 == 0 && i26 == 1013) {
                        int intExtra2 = intent.getIntExtra("k_req_occasion", 0);
                        int intExtra3 = intent.getIntExtra("k_version", -1);
                        int intExtra4 = intent.getIntExtra("k_peak_version", -1);
                        int intExtra5 = intent.getIntExtra("k_offset", 0);
                        int i27 = configurationService$RespGetConfigByPage.page_info.get().version.get();
                        int i28 = configurationService$RespGetConfigByPage.page_info.get().task_id.get();
                        int i29 = configurationService$RespGetConfigByPage.stagger_version.get();
                        try {
                            Object[] objArr = new Object[8];
                            objArr[0] = Integer.valueOf(intExtra2);
                            try {
                                objArr[1] = Integer.valueOf(intExtra3);
                                objArr[2] = Integer.valueOf(intExtra4);
                                objArr[3] = Integer.valueOf(intExtra5);
                                objArr[4] = Integer.valueOf(i27);
                                objArr[5] = Integer.valueOf(i29);
                                objArr[6] = Integer.valueOf(i28);
                                objArr[7] = Long.valueOf(longExtra);
                                String format = String.format("onReceive CMD_GET_CONFIG reqOccasion=%s reqVersion=%s reqPeakVersion=%s reqOffset=%s, rspVersion=%s, rspPeakVersion=%s, rspTaskId=%s reqAdcode=%d", objArr);
                                z29 = true;
                                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, format);
                                if (intExtra5 == 0 && intExtra3 == i27) {
                                    try {
                                        if (QLog.isColorLevel()) {
                                            QLog.i("SpringHb_SpringHbEntranceConfigServlet", 2, "onReceive CMD_GET_CONFIG no config need update.");
                                        }
                                        if (intExtra4 != i29) {
                                            z27 = true;
                                        } else {
                                            z27 = false;
                                        }
                                        if (configurationService$RespGetConfigByPage.delay_time.has()) {
                                            arrayList2 = (ArrayList) configurationService$RespGetConfigByPage.delay_time.get();
                                        } else {
                                            arrayList2 = null;
                                        }
                                        try {
                                            gVar.y(false, z27, i27, i29, i28, null, arrayList2, intExtra2, true, longExtra);
                                        } catch (Throwable th5) {
                                            th = th5;
                                            i18 = 1;
                                            z16 = false;
                                            i3 = i18;
                                            QLog.e("SpringHb_SpringHbEntranceConfigServlet", i3, "onReceive fail " + th.getMessage(), th);
                                            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                            if (peekAppRuntime != null) {
                                            }
                                            z28 = z16;
                                            c(intent, z28, z17);
                                        }
                                    } catch (Throwable th6) {
                                        th = th6;
                                        i18 = 1;
                                    }
                                } else if ((intExtra5 == 0 && intExtra3 != i27) || (intExtra5 != 0 && intExtra3 == i27)) {
                                    try {
                                        configurationService$PageRespInfo = configurationService$RespGetConfigByPage.page_info.get();
                                        byte[] byteArrayExtra = intent.getByteArrayExtra("k_buff");
                                        byte[] byteArray = configurationService$RespGetConfigByPage.content.get().toByteArray();
                                        if (byteArrayExtra != null) {
                                            try {
                                                length = byteArrayExtra.length;
                                            } catch (Throwable th7) {
                                                th = th7;
                                                z16 = false;
                                                i3 = 1;
                                                QLog.e("SpringHb_SpringHbEntranceConfigServlet", i3, "onReceive fail " + th.getMessage(), th);
                                                peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                                if (peekAppRuntime != null) {
                                                }
                                                z28 = z16;
                                                c(intent, z28, z17);
                                            }
                                        } else {
                                            length = 0;
                                        }
                                        ByteArrayBuffer byteArrayBuffer = new ByteArrayBuffer(length + byteArray.length);
                                        if (byteArrayExtra != null) {
                                            try {
                                                z18 = false;
                                                i16 = 0;
                                            } catch (Throwable th8) {
                                                th = th8;
                                                z18 = false;
                                            }
                                            try {
                                                byteArrayBuffer.append(byteArrayExtra, 0, byteArrayExtra.length);
                                            } catch (Throwable th9) {
                                                th = th9;
                                                z16 = z18;
                                                i3 = 1;
                                                QLog.e("SpringHb_SpringHbEntranceConfigServlet", i3, "onReceive fail " + th.getMessage(), th);
                                                peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                                if (peekAppRuntime != null) {
                                                    ISpringHbReportApi iSpringHbReportApi = (ISpringHbReportApi) peekAppRuntime.getRuntimeService(ISpringHbReportApi.class, "all");
                                                    String[] strArr = new String[i3];
                                                    z17 = false;
                                                    strArr[0] = Log.getStackTraceString(th);
                                                    iSpringHbReportApi.reportExCatch(303, th, strArr);
                                                } else {
                                                    z17 = false;
                                                }
                                                z28 = z16;
                                                c(intent, z28, z17);
                                            }
                                        } else {
                                            i16 = 0;
                                        }
                                        byteArrayBuffer.append(byteArray, i16, byteArray.length);
                                        buffer = byteArrayBuffer.buffer();
                                        i17 = configurationService$PageRespInfo.next_offset.get();
                                        r123 = -1;
                                        r122 = -1;
                                    } catch (Throwable th10) {
                                        th = th10;
                                        r122 = 1;
                                    }
                                    try {
                                        try {
                                            if (i17 == -1) {
                                                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG no more config to request.");
                                                String str = configurationService$PageRespInfo.md5.get();
                                                String d16 = o.d(buffer);
                                                int i36 = configurationService$PageRespInfo.total_size.get();
                                                if (buffer != null && buffer.length != 0 && i36 != 0) {
                                                    if (i36 > 0) {
                                                        if (TextUtils.equals(d16, str)) {
                                                            r123 = 1;
                                                            QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG get new config.");
                                                            if (configurationService$PageRespInfo.compress.get() == 1) {
                                                                buffer = b(buffer);
                                                            }
                                                            if (buffer != null) {
                                                                if (configurationService$RespGetConfigByPage.delay_time.has()) {
                                                                    arrayList = (ArrayList) configurationService$RespGetConfigByPage.delay_time.get();
                                                                } else {
                                                                    arrayList = null;
                                                                }
                                                                String str2 = new String(buffer, "utf-8");
                                                                if (intExtra4 != i29) {
                                                                    z26 = true;
                                                                } else {
                                                                    z26 = false;
                                                                }
                                                                gVar.y(true, z26, i27, i29, i28, str2, arrayList, intExtra2, true, longExtra);
                                                            } else {
                                                                QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG config inflate fail.");
                                                            }
                                                        }
                                                    }
                                                    r123 = 1;
                                                    QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG config in package invalid?");
                                                }
                                                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG remote config was cleaned.");
                                                gVar.y(true, true, i27, i29, i28, null, null, intExtra2, true, longExtra);
                                            } else {
                                                r123 = 1;
                                                if (i17 != 0) {
                                                    QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG request more config.");
                                                    gVar.m(intExtra2, i27, intExtra4, i17, configurationService$PageRespInfo.task_id.get(), configurationService$PageRespInfo.cookies.get().toByteArray(), buffer, longExtra, false);
                                                    return;
                                                }
                                                QLog.e("SpringHb_SpringHbEntranceConfigServlet", 1, "onReceive CMD_GET_CONFIG some thing wrong?");
                                            }
                                            z19 = r123;
                                            z28 = z19;
                                            z29 = false;
                                        } catch (Throwable th11) {
                                            th = th11;
                                            z16 = false;
                                            i3 = r122;
                                            QLog.e("SpringHb_SpringHbEntranceConfigServlet", i3, "onReceive fail " + th.getMessage(), th);
                                            peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                            if (peekAppRuntime != null) {
                                            }
                                            z28 = z16;
                                            c(intent, z28, z17);
                                        }
                                    } catch (Throwable th12) {
                                        th = th12;
                                        z16 = r123;
                                        i3 = r123;
                                        QLog.e("SpringHb_SpringHbEntranceConfigServlet", i3, "onReceive fail " + th.getMessage(), th);
                                        peekAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
                                        if (peekAppRuntime != null) {
                                        }
                                        z28 = z16;
                                        c(intent, z28, z17);
                                    }
                                }
                                z19 = false;
                                z28 = z19;
                                z29 = false;
                            } catch (Throwable th13) {
                                th = th13;
                                r122 = 1;
                            }
                        } catch (Throwable th14) {
                            th = th14;
                            r122 = 1;
                        }
                    }
                    z28 = true;
                }
                z17 = z29;
            } catch (Throwable th15) {
                th = th15;
                r122 = z29;
            }
        } else {
            z17 = false;
            if (intExtra == 1) {
                z17 = true;
            }
            z28 = z17;
        }
        c(intent, z28, z17);
    }

    @Override // com.tencent.biz.m, mqq.app.MSFServlet
    public void onSend(Intent intent, Packet packet) {
        String str;
        byte[] b16;
        String str2;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this, (Object) intent, (Object) packet);
            return;
        }
        int intExtra = intent.getIntExtra("k_cmd", -1);
        int intExtra2 = intent.getIntExtra("k_retry", 0);
        boolean booleanExtra = intent.getBooleanExtra("k_new_page", false);
        QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("onSend cmd=%s retry=%s newPage=%s", Integer.valueOf(intExtra), Integer.valueOf(intExtra2), Boolean.valueOf(booleanExtra)));
        if (intExtra2 != 0 && !booleanExtra) {
            str2 = intent.getStringExtra("k_sso_id");
            b16 = intent.getByteArrayExtra("k_sso_data");
            intent.putExtra("k_new_page", false);
        } else {
            if (intExtra != 1) {
                str2 = null;
                b16 = null;
                str = "k_sso_data";
            } else {
                int intExtra3 = intent.getIntExtra("k_id", 0);
                int intExtra4 = intent.getIntExtra("k_offset", 0);
                int intExtra5 = intent.getIntExtra("k_version", 0);
                int intExtra6 = intent.getIntExtra("k_peak_version", 0);
                str = "k_sso_data";
                long longExtra = intent.getLongExtra("key_req_adcode", 0L);
                byte[] byteArrayExtra = intent.getByteArrayExtra("k_cookie");
                QLog.i("SpringHb_SpringHbEntranceConfigServlet", 1, String.format("onSend CMD_GET_CONFIG taskId=%s offset=%s version=%s peakVersion=%s cookie=%s adCode=%s", Integer.valueOf(intExtra3), Integer.valueOf(intExtra4), Integer.valueOf(intExtra5), Integer.valueOf(intExtra6), Arrays.toString(byteArrayExtra), Long.valueOf(longExtra)));
                ConfigurationService$PageReqInfo configurationService$PageReqInfo = new ConfigurationService$PageReqInfo();
                configurationService$PageReqInfo.task_id.set(intExtra3);
                configurationService$PageReqInfo.offset.set(intExtra4);
                configurationService$PageReqInfo.version.set(intExtra5);
                if (byteArrayExtra != null) {
                    configurationService$PageReqInfo.cookies.set(ByteStringMicro.copyFrom(byteArrayExtra));
                }
                ConfigurationService$Screen configurationService$Screen = new ConfigurationService$Screen();
                configurationService$Screen.setHasFlag(true);
                configurationService$Screen.model.set("");
                configurationService$Screen.width.set((int) ah.x());
                configurationService$Screen.height.set((int) ah.w());
                configurationService$Screen.dpi.set(ah.v());
                configurationService$Screen.multi_touch.set(ah.q0());
                ConfigurationService$DeviceInfo configurationService$DeviceInfo = new ConfigurationService$DeviceInfo();
                configurationService$DeviceInfo.setHasFlag(true);
                configurationService$DeviceInfo.brand.set(ah.C());
                configurationService$DeviceInfo.model.set(ah.F());
                configurationService$DeviceInfo.screen = configurationService$Screen;
                ConfigurationService$ReqGetConfigByPage configurationService$ReqGetConfigByPage = new ConfigurationService$ReqGetConfigByPage();
                configurationService$ReqGetConfigByPage.page_info.set(configurationService$PageReqInfo);
                configurationService$ReqGetConfigByPage.device_info.set(configurationService$DeviceInfo);
                configurationService$ReqGetConfigByPage.type.set(1013);
                configurationService$ReqGetConfigByPage.adcode.set(longExtra);
                configurationService$ReqGetConfigByPage.stagger_version.set(intExtra6);
                b16 = fh.b(configurationService$ReqGetConfigByPage.toByteArray());
                str2 = "ConfigurationService.ReqGetConfigByPage";
            }
            if (str2 != null && !booleanExtra) {
                intent.putExtra("k_sso_id", str2);
                intent.putExtra(str, b16);
            }
        }
        if (str2 != null && b16 != null) {
            packet.setSSOCommand(str2);
            packet.putSendData(b16);
        }
    }
}
