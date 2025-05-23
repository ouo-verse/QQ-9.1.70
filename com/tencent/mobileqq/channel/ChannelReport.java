package com.tencent.mobileqq.channel;

import android.provider.Settings;
import android.text.TextUtils;
import com.google.protobuf.nano.MessageNano;
import com.heytap.databaseengine.utils.DateUtil;
import com.tencent.mobileqq.channel.report.ReportReq;
import com.tencent.mobileqq.channel.report.SingleData;
import com.tencent.mobileqq.fe.FEKit;
import com.tencent.mobileqq.fe.a;
import com.tencent.mobileqq.fe.c;
import com.tencent.mobileqq.fe.d;
import com.tencent.mobileqq.fe.e;
import com.tencent.mobileqq.fe.f;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qsec.qsecurity.QSecConfig;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTConstants;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import com.tencent.tuxmetersdk.export.config.TuxConstants;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* compiled from: P */
/* loaded from: classes11.dex */
public class ChannelReport {
    static IPatchRedirector $redirector_ = null;
    private static final String EVENT_TYPE_CLICK = "click";
    private static final String EVENT_TYPE_EXPOSURE = "exposure";
    private static final String EVENT_TYPE_STEP = "step";
    private static final String REPORT_CMD = "trpc.o3.report.Report.SsoEventReport";
    private static final String TAG = "FEKit_R";
    private static ChannelReport mInstance;

    ChannelReport() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    static String[] arrayConcat(String[] strArr, String[] strArr2) {
        String[] strArr3 = new String[strArr.length + strArr2.length];
        System.arraycopy(strArr, 0, strArr3, 0, strArr.length);
        System.arraycopy(strArr2, 0, strArr3, strArr.length, strArr2.length);
        return strArr3;
    }

    private static boolean checkReportTimeResult(long j3) {
        if (j3 > 30000) {
            return true;
        }
        try {
            if (Double.parseDouble(FEKit.getInstance().sleepCheckResult) > 1.0d) {
                return true;
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void eventReport(ArrayList<String> arrayList) {
        String f16 = e.b().f();
        ReportReq reportReq = new ReportReq();
        reportReq.attaId = "0df00071646";
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add(QSecConfig.business_qua);
        arrayList2.add(f16);
        arrayList2.addAll(arrayList);
        SingleData singleData = new SingleData();
        singleData.data = (String[]) arrayList2.toArray();
        reportReq.singleDatas = new SingleData[]{singleData};
        ChannelManager.getInstance().sendMessage(REPORT_CMD, MessageNano.toByteArray(reportReq), 0L);
    }

    public static ChannelReport getInstance() {
        if (mInstance == null) {
            synchronized (ChannelReport.class) {
                if (mInstance == null) {
                    mInstance = new ChannelReport();
                }
            }
        }
        return mInstance;
    }

    private static boolean isRDM() {
        return QSecConfig.business_qua.contains("_RDM_");
    }

    public static boolean isReportOnceForever(String str) {
        String str2 = FEKit.getInstance().getCurUin() + "|" + str;
        if (TextUtils.equals(f.a().g(str2), "1")) {
            return false;
        }
        f.a().f(str2, "1");
        return true;
    }

    public static boolean isReportOnceOfDay(String str) {
        String format;
        String str2;
        try {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT);
            String curUin = FEKit.getInstance().getCurUin();
            format = simpleDateFormat.format(date);
            str2 = curUin + "|" + str;
        } catch (Throwable unused) {
        }
        if (TextUtils.equals(f.a().g(str2), format)) {
            return false;
        }
        f.a().f(str2, format);
        return true;
    }

    public static boolean sampling(int i3) {
        if (((int) (Math.random() * i3)) == 0) {
            return true;
        }
        return false;
    }

    public void commonReport(String str, String str2, String[] strArr) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, this, str, str2, strArr);
            return;
        }
        ReportReq reportReq = new ReportReq();
        reportReq.attaId = str;
        SingleData singleData = new SingleData();
        String[] strArr2 = {QSecConfig.business_qua, e.b().f(), QSecConfig.business_guid, QSecConfig.business_q36, str2};
        singleData.data = strArr2;
        singleData.data = arrayConcat(strArr2, strArr);
        reportReq.singleDatas = new SingleData[]{singleData};
        ChannelManager.getInstance().sendMessage("trpc.o3.report.Report.SsoReport", MessageNano.toByteArray(reportReq), 0L);
    }

    public void reportClick(String str, String str2, float f16, float f17) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            iPatchRedirector.redirect((short) 6, this, str, str2, Float.valueOf(f16), Float.valueOf(f17));
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("click");
        arrayList.add(str);
        arrayList.add(str2);
        arrayList.add(f16 + "|" + f17);
        eventReport(arrayList);
    }

    public void reportExposure(String str, String str2) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, (Object) str, (Object) str2);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("exposure");
        arrayList.add(str);
        arrayList.add(str2);
        eventReport(arrayList);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r6v3, types: [int] */
    /* JADX WARN: Type inference failed for: r6v4 */
    /* JADX WARN: Type inference failed for: r6v5 */
    public void reportInitTime() {
        long j3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this);
            return;
        }
        if (!sampling(10000) && !isRDM()) {
            return;
        }
        long j16 = FEKit.getInstance().initTime;
        long g16 = e.b().g();
        if (a.INSTANCE.a()) {
            c.a(TAG, 1, "not report in background");
            return;
        }
        if (checkReportTimeResult(j16)) {
            c.a(TAG, 1, "sleepCheckResult error!:" + FEKit.getInstance().sleepCheckResult);
            return;
        }
        String str = FEKit.getInstance().initErrorMsg;
        if (j16 > 0 && g16 > 0) {
            j3 = j16 * 1000;
        } else {
            str = String.valueOf(1000 * j16);
            c.a(TAG, 1, "initTime:" + j16 + ",soLoadTime:" + g16);
            j3 = -1;
        }
        ?? r65 = e.b().e();
        if (d.d()) {
            r65 = 2;
        }
        commonReport("0b500076578", DTConstants.TAG.SDK_INIT, new String[]{String.valueOf(j3), "", "", FEKit.getInstance().sleepCheckResult, str, String.valueOf(g16), String.valueOf((int) r65)});
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v10 */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v9 */
    public void reportLoadFixedSo() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
            iPatchRedirector.redirect((short) 3, (Object) this);
            return;
        }
        try {
            e b16 = e.b();
            if (!b16.h()) {
                return;
            }
            boolean isReportOnceForever = isReportOnceForever("years_so_version_" + e.b().f());
            if (!isReportOnceOfDay("day_so_version_" + e.b().f())) {
                return;
            }
            ?? r16 = b16.e();
            if (d.d()) {
                r16 = 2;
            }
            commonReport("0df00071646", "load_so_fix", new String[]{String.valueOf((int) r16), String.valueOf(isReportOnceForever ? 1 : 0), "", "", "", "", ""});
        } catch (Throwable unused) {
        }
    }

    public void reportStep(String str) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 8)) {
            iPatchRedirector.redirect((short) 8, (Object) this, (Object) str);
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("exposure");
        arrayList.add(str);
        eventReport(arrayList);
    }

    public void reportTZ() {
        int i3;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
            return;
        }
        try {
            if (!isReportOnceOfDay("reportTZ20131016")) {
                return;
            }
            TimeZone timeZone = TimeZone.getDefault();
            String id5 = timeZone.getID();
            String displayName = timeZone.getDisplayName(false, 0);
            String locale = Locale.getDefault().toString();
            if (!"Asia/Shanghai".equals(id5) && !DateUtil.TIME_ZONE_8.equals(id5) && !TuxConstants.BEIJING_TIMEZONE.equals(id5)) {
                try {
                    i3 = Settings.Global.getInt(FEKit.getInstance().getContext().getContentResolver(), "auto_time_zone");
                } catch (Throwable unused) {
                    i3 = -1;
                }
                commonReport("00e00075618", "timezone", new String[]{id5, displayName, locale, String.valueOf(i3)});
            }
        } catch (Throwable th5) {
            c.a(TAG, 1, "report exception :" + th5);
        }
    }
}
