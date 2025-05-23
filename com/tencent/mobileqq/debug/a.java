package com.tencent.mobileqq.debug;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.Log;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.bugly.common.constants.Constants;
import com.tencent.bugly.common.reporter.builder.ReportDataBuilder;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.R;
import com.tencent.mobileqq.activity.NotificationActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.bc;
import com.tencent.mobileqq.app.bd;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.utils.ah;
import com.tencent.mobileqq.utils.cr;
import com.tencent.open.base.l;
import com.tencent.qmethod.pandoraex.monitor.DeviceInfoMonitor;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.report.MiniAppRealTimeLogReporter;
import com.tencent.util.Pair;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import org.json.JSONException;
import org.json.JSONObject;
import wns_proxy.HttpRsp;

/* compiled from: P */
/* loaded from: classes10.dex */
public class a {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    private static final bd f203473a;

    /* renamed from: b, reason: collision with root package name */
    protected static final bc f203474b;

    /* renamed from: c, reason: collision with root package name */
    static String f203475c;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(35786);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 2)) {
            redirector.redirect((short) 2);
            return;
        }
        bd newHandlerRecycleThread = ThreadManagerV2.newHandlerRecycleThread("CIOSubmitThread", 1);
        f203473a = newHandlerRecycleThread;
        f203474b = newHandlerRecycleThread.b();
        StringBuilder sb5 = new StringBuilder();
        sb5.append(Environment.getExternalStorageDirectory());
        String str = File.separator;
        sb5.append(str);
        sb5.append("cio_mobile_qq");
        sb5.append(str);
        f203475c = sb5.toString();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static void d() {
        File[] listFiles;
        File file = new File(f203475c);
        if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (QLog.isColorLevel()) {
                    QLog.d("CIOSubmitUtils", 2, "filename:" + file2.getAbsolutePath());
                }
                if (file2.getAbsolutePath().endsWith("@23@android_cio_reporter.zip")) {
                    cr.h(file2);
                }
            }
        }
    }

    private static String e(int i3) {
        if (i3 == 0) {
            return HardCodeUtil.qqStr(R.string.f207865b6);
        }
        if (i3 == 1) {
            return HardCodeUtil.qqStr(R.string.f207945bd);
        }
        if (i3 == 2) {
            return HardCodeUtil.qqStr(R.string.f207965bf);
        }
        if (i3 == 3) {
            return HardCodeUtil.qqStr(R.string.f207895b9);
        }
        throw new IllegalStateException("Illegal level.");
    }

    private static String f(int i3) {
        if (i3 == 0) {
            return HardCodeUtil.qqStr(R.string.f208035bm);
        }
        if (i3 == 1) {
            return HardCodeUtil.qqStr(R.string.f207925bb);
        }
        if (i3 == 2) {
            return HardCodeUtil.qqStr(R.string.f207985bh);
        }
        if (i3 == 3) {
            return HardCodeUtil.qqStr(R.string.f207935bc);
        }
        throw new IllegalStateException("Illegal priority.");
    }

    public static JSONObject g(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("version", str3);
        jSONObject.put("manu", Build.BRAND);
        jSONObject.put("device", DeviceInfoMonitor.getModel());
        jSONObject.put("api_ver", 1);
        jSONObject.put("plugin_ver", 1);
        jSONObject.put(ReportDataBuilder.KEY_CLIENT_IDENTIFY, UUID.randomUUID());
        jSONObject.put("platform", "android");
        jSONObject.put("plugin", 133);
        jSONObject.put("p_id", 1);
        jSONObject.put("rdmuuid", "0");
        jSONObject.put("os", Build.VERSION.RELEASE);
        jSONObject.put("uin", str);
        jSONObject.put("deviceid", "");
        jSONObject.put("fileObj", str2);
        return jSONObject;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void h(String str, String str2, String str3, String str4, String str5) {
        String a16;
        Time time = new Time();
        time.setToNow();
        String str6 = AppSetting.f99543c;
        if (str6.equals("0")) {
            str6 = b.b();
        }
        String str7 = time.year + "-" + (time.month + 1) + "-" + time.monthDay + " " + time.hour + ":" + time.minute + ":" + time.second;
        String j3 = j();
        if (TextUtils.isEmpty(b.a())) {
            a16 = "RDM";
        } else {
            a16 = b.a();
        }
        cr.l(str + "/param.txt", HardCodeUtil.qqStr(R.string.f208015bk) + AppSetting.f99554n + "\r\n" + HardCodeUtil.qqStr(R.string.f208025bl) + str2 + "\r\n\u3010Android\u7248\u672c\u3011: " + Build.VERSION.RELEASE + "\r\n" + HardCodeUtil.qqStr(R.string.f207995bi) + str7 + "\r\n\r\n\u3010title\u3011: " + str3 + "\r\n" + HardCodeUtil.qqStr(R.string.f207915ba) + str4 + "\r\n\u3010svn\u3011: " + str6 + " \r\n" + HardCodeUtil.qqStr(R.string.f208045bn) + a16 + "\r\n\r\ncio:" + j3 + "\r\nuin: " + str5);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void i(String str, String str2, String str3, String str4, String str5, String str6, int i3, int i16) {
        String a16;
        Time time = new Time();
        time.setToNow();
        String str7 = AppSetting.f99543c;
        if (str7.equals("0")) {
            str7 = b.b();
        }
        String str8 = time.year + "-" + (time.month + 1) + "-" + time.monthDay + " " + time.hour + ":" + time.minute + ":" + time.second;
        if (TextUtils.isEmpty(b.a())) {
            a16 = "RDM";
        } else {
            a16 = b.a();
        }
        String str9 = HardCodeUtil.qqStr(R.string.f208055bo) + AppSetting.f99554n + "\r\n" + HardCodeUtil.qqStr(R.string.f207975bg) + str2 + "\r\n\u3010Android\u7248\u672c\u3011: " + Build.VERSION.RELEASE + "\r\n" + HardCodeUtil.qqStr(R.string.f208005bj) + str8 + "\r\n\r\n\u3010title\u3011: " + str3 + "\r\n\u3010activityName\u3011: " + str6 + "\r\n" + HardCodeUtil.qqStr(R.string.f207955be) + str4 + "\r\n\u3010svn\u3011: " + str7 + " \r\n" + HardCodeUtil.qqStr(R.string.f207885b8) + a16 + "\r\n";
        if (i3 != 1 || i16 != 1) {
            str9 = str9 + HardCodeUtil.qqStr(R.string.f207875b7) + e(i16) + "\r\n" + HardCodeUtil.qqStr(R.string.f207905b_) + f(i3) + "\r\n";
        }
        cr.l(str + "/param.txt", str9 + "\r\ncio:" + str2 + "\r\nuin: " + str5);
    }

    static String j() {
        return new String[]{"remilelei;zhuoxu;", "zhuoxu;v_zzyzeng;", "v_zzyzeng;v_fxincheng;", "v_fxincheng;v_binhhe;", "v_binhhe;ronxu;", "ronxu;rejectliu;", "rejectliu;remilelei;"}[Calendar.getInstance().get(7) - 1];
    }

    public static String k() {
        AppRuntime waitAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime();
        if (waitAppRuntime == null || waitAppRuntime.getAccount() == null) {
            return "0";
        }
        return waitAppRuntime.getAccount();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String l(String str, String str2) {
        C7483a c7483a = new C7483a();
        if (QLog.isColorLevel()) {
            QLog.d("CIOSubmitUtils", 2, "deviceID:" + ah.z());
            QLog.d("CIOSubmitUtils", 2, "versionName:" + AppSetting.f99554n);
            QLog.d("CIOSubmitUtils", 2, "firma" + DeviceInfoMonitor.getModel());
            QLog.d("CIOSubmitUtils", 2, "operationSysandroid " + Build.VERSION.RELEASE);
            QLog.d("CIOSubmitUtils", 2, "platformandroid");
            QLog.d("CIOSubmitUtils", 2, "mzipname:" + str + " allName:" + str2);
        }
        c7483a.b(Constants.SP_DEVICE_ID, ah.z());
        c7483a.b("versionName", AppSetting.f99554n);
        c7483a.b("firma", DeviceInfoMonitor.getModel());
        c7483a.b("operationSys", "android " + Build.VERSION.RELEASE);
        c7483a.b("platform", "android");
        c7483a.a(str2);
        String e16 = c7483a.e();
        if (QLog.isColorLevel()) {
            QLog.d("CIOSubmitUtils", 2, "the result:" + e16);
        }
        return e16;
    }

    public static void m(String str) {
        cr.f(str, false);
        new File(str).mkdir();
        if (QLog.isColorLevel()) {
            QLog.d("CIOSubmitUtils", 2, "touch folder:" + str + " completed");
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static Pair<String, String> n(String str, String str2) {
        String str3 = System.currentTimeMillis() + ContainerUtils.KEY_VALUE_DELIMITER;
        String str4 = str3 + (str2 + "@23@android_cio_reporter.zip");
        String str5 = f203475c + str4;
        if (QLog.isColorLevel()) {
            QLog.d("CIOSubmitUtils", 2, "start to zip log files");
        }
        try {
            l.d(str, str5);
        } catch (Exception e16) {
            e16.printStackTrace();
        }
        return new Pair<>(str4, str5);
    }

    /* compiled from: P */
    /* renamed from: com.tencent.mobileqq.debug.a$a, reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C7483a {
        static IPatchRedirector $redirector_;

        /* renamed from: a, reason: collision with root package name */
        private ConcurrentHashMap<String, String> f203476a;

        /* renamed from: b, reason: collision with root package name */
        private ConcurrentLinkedQueue<String[]> f203477b;

        /* renamed from: c, reason: collision with root package name */
        Context f203478c;

        /* renamed from: d, reason: collision with root package name */
        String f203479d;

        /* renamed from: e, reason: collision with root package name */
        String f203480e;

        /* renamed from: f, reason: collision with root package name */
        JSONObject f203481f;

        public C7483a() {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
                iPatchRedirector.redirect((short) 1, (Object) this);
                return;
            }
            this.f203476a = new ConcurrentHashMap<>();
            this.f203477b = new ConcurrentLinkedQueue<>();
            this.f203476a.put("username", "JLLLCKCOAODOBJFK");
            this.f203476a.put(NotificationActivity.PASSWORD, "ALFLMLILPLBJFK");
        }

        public void a(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
                iPatchRedirector.redirect((short) 4, (Object) this, (Object) str);
                return;
            }
            if (str != null && str.length() != 0) {
                this.f203477b.add(new String[]{"file" + this.f203477b.size(), str.substring(str.lastIndexOf("/") + 1), "application/x-zip-compressed", str});
            }
        }

        public void b(String str, String str2) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 3)) {
                iPatchRedirector.redirect((short) 3, (Object) this, (Object) str, (Object) str2);
            } else if (str != null && str2 != null && str.length() != 0 && str2.length() != 0) {
                this.f203476a.put(str, str2);
            }
        }

        public void c(String str) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
                iPatchRedirector.redirect((short) 5, (Object) this, (Object) str);
            } else {
                this.f203479d = str;
                this.f203480e = "27182818284590452353602874713526";
            }
        }

        public void d(JSONObject jSONObject) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
                iPatchRedirector.redirect((short) 6, (Object) this, (Object) jSONObject);
            } else {
                this.f203481f = jSONObject;
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Not initialized variable reg: 11, insn: 0x0229: MOVE (r4 I:??[OBJECT, ARRAY]) = (r11 I:??[OBJECT, ARRAY]) (LINE:554), block:B:141:0x0227 */
        /* JADX WARN: Removed duplicated region for block: B:49:0x0218 A[Catch: Exception -> 0x0214, TryCatch #10 {Exception -> 0x0214, blocks: (B:60:0x0210, B:49:0x0218, B:51:0x021d), top: B:59:0x0210 }] */
        /* JADX WARN: Removed duplicated region for block: B:51:0x021d A[Catch: Exception -> 0x0214, TRY_LEAVE, TryCatch #10 {Exception -> 0x0214, blocks: (B:60:0x0210, B:49:0x0218, B:51:0x021d), top: B:59:0x0210 }] */
        /* JADX WARN: Removed duplicated region for block: B:58:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:59:0x0210 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:67:0x01f9 A[Catch: Exception -> 0x01f5, TryCatch #8 {Exception -> 0x01f5, blocks: (B:78:0x01f1, B:67:0x01f9, B:69:0x01fe), top: B:77:0x01f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:69:0x01fe A[Catch: Exception -> 0x01f5, TRY_LEAVE, TryCatch #8 {Exception -> 0x01f5, blocks: (B:78:0x01f1, B:67:0x01f9, B:69:0x01fe), top: B:77:0x01f1 }] */
        /* JADX WARN: Removed duplicated region for block: B:76:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:77:0x01f1 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:84:0x0235 A[Catch: Exception -> 0x0231, TryCatch #13 {Exception -> 0x0231, blocks: (B:95:0x022d, B:84:0x0235, B:86:0x023a), top: B:94:0x022d }] */
        /* JADX WARN: Removed duplicated region for block: B:86:0x023a A[Catch: Exception -> 0x0231, TRY_LEAVE, TryCatch #13 {Exception -> 0x0231, blocks: (B:95:0x022d, B:84:0x0235, B:86:0x023a), top: B:94:0x022d }] */
        /* JADX WARN: Removed duplicated region for block: B:93:? A[SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x022d A[EXC_TOP_SPLITTER, SYNTHETIC] */
        /* JADX WARN: Type inference failed for: r16v0 */
        /* JADX WARN: Type inference failed for: r16v1, types: [java.io.InputStream] */
        /* JADX WARN: Type inference failed for: r16v2 */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r3v19 */
        /* JADX WARN: Type inference failed for: r3v2, types: [java.net.HttpURLConnection] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public String e() {
            ?? r16;
            DataInputStream dataInputStream;
            DataInputStream dataInputStream2;
            Throwable th5;
            ?? r36;
            HttpURLConnection httpURLConnection;
            InputStream inputStream;
            HttpURLConnection httpURLConnection2;
            DataInputStream dataInputStream3;
            HttpURLConnection httpURLConnection3;
            DataInputStream dataInputStream4;
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
                return (String) iPatchRedirector.redirect((short) 7, (Object) this);
            }
            boolean isNetSupport = AppNetConnInfo.isNetSupport();
            try {
                if (!isNetSupport) {
                    return null;
                }
                try {
                    httpURLConnection2 = (HttpURLConnection) new URL("https://magnifier.tencent.com/v3/mobile/chunksUploadFile").openConnection();
                } catch (Exception e16) {
                    e = e16;
                    inputStream = null;
                    httpURLConnection2 = null;
                } catch (OutOfMemoryError e17) {
                    e = e17;
                    inputStream = null;
                    httpURLConnection2 = null;
                } catch (Throwable th6) {
                    th5 = th6;
                    httpURLConnection = null;
                }
                try {
                    httpURLConnection2.setRequestProperty("Content-Type", "multipart/form-data; boundary=----MagnifierFormBoundarySMFEtUYQG6r5B920");
                    httpURLConnection2.setRequestProperty("Charsert", "UTF-8");
                    char c16 = 1;
                    httpURLConnection2.setDoOutput(true);
                    httpURLConnection2.setDoInput(true);
                    char c17 = 0;
                    httpURLConnection2.setUseCaches(false);
                    httpURLConnection2.setRequestMethod("POST");
                    OutputStream outputStream = httpURLConnection2.getOutputStream();
                    StringBuffer stringBuffer = new StringBuffer("\r\n");
                    String str = "\r\n------MagnifierFormBoundarySMFEtUYQG6r5B920--\r\n";
                    ConcurrentHashMap<String, String> concurrentHashMap = this.f203476a;
                    if (concurrentHashMap != null) {
                        for (String str2 : concurrentHashMap.keySet()) {
                            String str3 = this.f203476a.get(str2);
                            stringBuffer.append("Content-Disposition: form-data; name=\"");
                            stringBuffer.append(str2);
                            stringBuffer.append("\"\r\n");
                            stringBuffer.append("\r\n");
                            stringBuffer.append(str3);
                            stringBuffer.append("\r\n");
                            stringBuffer.append("--");
                            stringBuffer.append("----MagnifierFormBoundarySMFEtUYQG6r5B920");
                            stringBuffer.append("\r\n");
                        }
                    }
                    outputStream.write(("------MagnifierFormBoundarySMFEtUYQG6r5B920" + stringBuffer.toString()).getBytes("utf-8"));
                    StringBuffer stringBuffer2 = new StringBuffer();
                    ConcurrentLinkedQueue<String[]> concurrentLinkedQueue = this.f203477b;
                    if (concurrentLinkedQueue != null) {
                        int size = concurrentLinkedQueue.size();
                        int i3 = 0;
                        dataInputStream3 = null;
                        while (i3 < size) {
                            try {
                                String[] poll = this.f203477b.poll();
                                String str4 = poll[c17];
                                String str5 = poll[c16];
                                String str6 = poll[2];
                                String str7 = poll[3];
                                stringBuffer2.append("Content-Disposition: form-data; name=\"");
                                stringBuffer2.append(str4);
                                stringBuffer2.append("\"; filename=\"");
                                stringBuffer2.append(str5);
                                stringBuffer2.append("\"\r\n");
                                stringBuffer2.append("Content-Type: ");
                                stringBuffer2.append(str6);
                                stringBuffer2.append(HttpRsp.HTTP_HEADER_END);
                                outputStream.write(stringBuffer2.toString().getBytes("utf-8"));
                                dataInputStream4 = new DataInputStream(new FileInputStream(new File(str7)));
                            } catch (Exception e18) {
                                e = e18;
                            } catch (OutOfMemoryError e19) {
                                e = e19;
                            } catch (Throwable th7) {
                                th5 = th7;
                                dataInputStream2 = dataInputStream3;
                                httpURLConnection3 = httpURLConnection2;
                            }
                            try {
                                byte[] bArr = new byte[MiniAppRealTimeLogReporter.MAX_CONTENT_SIZE];
                                while (true) {
                                    int read = dataInputStream4.read(bArr);
                                    if (read == -1) {
                                        break;
                                    }
                                    outputStream.write(bArr, 0, read);
                                }
                                if (i3 < size - 1) {
                                    outputStream.write(str.getBytes("utf-8"));
                                }
                                dataInputStream4.close();
                                i3++;
                                c16 = 1;
                                dataInputStream3 = dataInputStream4;
                                c17 = 0;
                            } catch (Exception e26) {
                                e = e26;
                                dataInputStream3 = dataInputStream4;
                                inputStream = null;
                                e.printStackTrace();
                                if (dataInputStream3 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection2 != null) {
                                }
                            } catch (OutOfMemoryError e27) {
                                e = e27;
                                dataInputStream3 = dataInputStream4;
                                inputStream = null;
                                e.printStackTrace();
                                if (dataInputStream3 != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (httpURLConnection2 != null) {
                                }
                            } catch (Throwable th8) {
                                th5 = th8;
                                dataInputStream2 = dataInputStream4;
                                httpURLConnection3 = httpURLConnection2;
                                r16 = 0;
                                r36 = httpURLConnection3;
                                if (dataInputStream2 != null) {
                                    try {
                                        dataInputStream2.close();
                                    } catch (Exception e28) {
                                        e28.printStackTrace();
                                        throw th5;
                                    }
                                }
                                if (r16 != 0) {
                                    r16.close();
                                }
                                if (r36 == 0) {
                                    r36.disconnect();
                                    throw th5;
                                }
                                throw th5;
                            }
                        }
                    } else {
                        dataInputStream3 = null;
                    }
                    outputStream.write(str.getBytes("utf-8"));
                    outputStream.close();
                    QLog.d("CIOSubmitUtils", 2, "responseCode:" + httpURLConnection2.getResponseCode());
                    inputStream = httpURLConnection2.getInputStream();
                } catch (Exception e29) {
                    e = e29;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection2;
                    dataInputStream3 = null;
                    e.printStackTrace();
                    if (dataInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                } catch (OutOfMemoryError e36) {
                    e = e36;
                    inputStream = null;
                    httpURLConnection2 = httpURLConnection2;
                    dataInputStream3 = null;
                    e.printStackTrace();
                    if (dataInputStream3 != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (httpURLConnection2 != null) {
                    }
                } catch (Throwable th9) {
                    th5 = th9;
                    httpURLConnection = httpURLConnection2;
                    dataInputStream2 = null;
                    httpURLConnection3 = httpURLConnection;
                    r16 = 0;
                    r36 = httpURLConnection3;
                    if (dataInputStream2 != null) {
                    }
                    if (r16 != 0) {
                    }
                    if (r36 == 0) {
                    }
                }
                try {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    while (true) {
                        int read2 = inputStream.read();
                        if (read2 == -1) {
                            break;
                        }
                        stringBuffer3.append((char) read2);
                    }
                    Log.v("aaa", stringBuffer3.toString());
                    String stringBuffer4 = stringBuffer3.toString();
                    if (dataInputStream3 != null) {
                        try {
                            dataInputStream3.close();
                        } catch (Exception e37) {
                            e37.printStackTrace();
                        }
                    }
                    inputStream.close();
                    httpURLConnection2.disconnect();
                    return stringBuffer4;
                } catch (Exception e38) {
                    e = e38;
                    e.printStackTrace();
                    if (dataInputStream3 != null) {
                        try {
                            dataInputStream3.close();
                        } catch (Exception e39) {
                            e39.printStackTrace();
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        return null;
                    }
                    return null;
                } catch (OutOfMemoryError e46) {
                    e = e46;
                    e.printStackTrace();
                    if (dataInputStream3 != null) {
                        try {
                            dataInputStream3.close();
                        } catch (Exception e47) {
                            e47.printStackTrace();
                            return null;
                        }
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                        return null;
                    }
                    return null;
                }
            } catch (Throwable th10) {
                r16 = "\r\n";
                dataInputStream2 = dataInputStream;
                th5 = th10;
                r36 = isNetSupport;
            }
        }

        public C7483a(Context context) {
            IPatchRedirector iPatchRedirector = $redirector_;
            if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
                iPatchRedirector.redirect((short) 2, (Object) this, (Object) context);
                return;
            }
            this.f203476a = new ConcurrentHashMap<>();
            this.f203477b = new ConcurrentLinkedQueue<>();
            this.f203478c = context;
        }
    }
}
