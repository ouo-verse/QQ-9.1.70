package com.tencent.camerasdk.avreport;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.File;
import java.io.FileOutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/* compiled from: P */
/* loaded from: classes5.dex */
public class AVReportCenter {
    static IPatchRedirector $redirector_;
    private static final String TAG;
    private static final AVReportCenter ourInstance;
    private String app;
    private Boolean auto;
    private Context context;
    private String dir;
    private boolean enable;
    private String imei;
    private volatile Handler ioHandler;
    private volatile HandlerThread ioThread;

    /* renamed from: os, reason: collision with root package name */
    private String f99066os;
    private Reporter reporter;
    private String tmpDir;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(12630);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 8)) {
            redirector.redirect((short) 8);
            return;
        }
        TAG = "AVReportCenter-" + Integer.toHexString(AVReportCenter.class.hashCode());
        ourInstance = new AVReportCenter();
    }

    AVReportCenter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
        } else {
            this.auto = Boolean.TRUE;
            this.enable = true;
        }
    }

    public static AVReportCenter getInstance() {
        return ourInstance;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hibernate(String str) {
        hibernate(str, "bean");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String toUrlParams(Map<String, Object> map) {
        String str = "attaid=06400000136&token=3598698434";
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value instanceof Number) {
                str = str + ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER + value.toString();
            } else if (value instanceof String) {
                try {
                    str = str + ContainerUtils.FIELD_DELIMITER + key + ContainerUtils.KEY_VALUE_DELIMITER + URLEncoder.encode(value.toString(), "UTF-8");
                } catch (UnsupportedEncodingException e16) {
                    e16.printStackTrace();
                }
            }
        }
        return str;
    }

    public void commit(BaseBean baseBean) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector == null || !iPatchRedirector.hasPatch((short) 3)) {
            commit(baseBean, Boolean.FALSE);
        } else {
            iPatchRedirector.redirect((short) 3, (Object) this, (Object) baseBean);
        }
    }

    public void flush() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 5)) {
            iPatchRedirector.redirect((short) 5, (Object) this);
        } else if (this.ioHandler != null) {
            this.ioHandler.post(new Runnable() { // from class: com.tencent.camerasdk.avreport.AVReportCenter.3
                static IPatchRedirector $redirector_;

                {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVReportCenter.this);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                    } else if (AVReportCenter.this.reporter != null) {
                        AVReportCenter.this.reporter.flush();
                    }
                }
            });
        }
    }

    public void init(Context context) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this, (Object) context);
            return;
        }
        if (!this.enable) {
            LogUtils.e(TAG, "init false.enable report: false");
            return;
        }
        LogUtils.e(TAG, "init.will new report thread.");
        this.context = context;
        if (this.ioHandler == null) {
            synchronized (AVReportCenter.class) {
                if (this.ioHandler != null) {
                    return;
                }
                try {
                    this.f99066os = "AEKit" + DeviceInfo.getApiLevelInt();
                    this.app = AppInfo.getPackageName(this.context);
                    StringBuilder sb5 = new StringBuilder();
                    sb5.append(this.context.getExternalCacheDir().getAbsolutePath());
                    String str = File.separator;
                    sb5.append(str);
                    sb5.append("AVReportCenter");
                    sb5.append(str);
                    sb5.append("Report");
                    this.dir = sb5.toString();
                    File file = new File(this.dir);
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    this.tmpDir = this.context.getExternalCacheDir().getAbsolutePath() + str + "AVReportCenter" + str + "Report_tmp";
                    File file2 = new File(this.tmpDir);
                    if (!file2.exists()) {
                        file2.mkdirs();
                    }
                    try {
                        this.imei = "0";
                    } catch (Exception e16) {
                        e16.printStackTrace();
                        this.imei = "0";
                    }
                    this.ioThread = new BaseHandlerThread(TAG);
                    this.ioThread.setDaemon(true);
                    this.ioThread.start();
                    do {
                    } while (!this.ioThread.isAlive());
                    this.ioHandler = new Handler(this.ioThread.getLooper());
                    this.ioHandler.post(new Runnable() { // from class: com.tencent.camerasdk.avreport.AVReportCenter.1
                        static IPatchRedirector $redirector_;

                        {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                                iPatchRedirector2.redirect((short) 1, (Object) this, (Object) AVReportCenter.this);
                            }
                        }

                        @Override // java.lang.Runnable
                        public void run() {
                            IPatchRedirector iPatchRedirector2 = $redirector_;
                            if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                                iPatchRedirector2.redirect((short) 2, (Object) this);
                                return;
                            }
                            File[] listFiles = new File(AVReportCenter.this.dir).listFiles();
                            if (listFiles != null) {
                                for (File file3 : listFiles) {
                                    file3.delete();
                                }
                            }
                            File[] listFiles2 = new File(AVReportCenter.this.tmpDir).listFiles();
                            if (listFiles2 != null) {
                                for (File file4 : listFiles2) {
                                    file4.delete();
                                }
                            }
                        }
                    });
                } catch (Exception e17) {
                    e17.printStackTrace();
                }
            }
        }
    }

    public boolean isEnable() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 6)) {
            return ((Boolean) iPatchRedirector.redirect((short) 6, (Object) this)).booleanValue();
        }
        return this.enable;
    }

    public void setEnable(boolean z16) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 7)) {
            iPatchRedirector.redirect((short) 7, (Object) this, z16);
        } else {
            this.enable = z16;
        }
    }

    private void hibernate(String str, String str2) {
        String str3 = this.dir;
        if (str3 != null && str3.length() != 0) {
            try {
                StringBuilder sb5 = new StringBuilder();
                sb5.append(this.tmpDir);
                String str4 = File.separator;
                sb5.append(str4);
                sb5.append(str2);
                sb5.append(".");
                sb5.append(System.nanoTime());
                File file = new File(sb5.toString());
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                fileOutputStream.write(str.getBytes());
                fileOutputStream.close();
                file.renameTo(new File(this.dir + str4 + str2 + "." + System.nanoTime()));
                return;
            } catch (Exception e16) {
                e16.printStackTrace();
                return;
            }
        }
        AVRLogUtils.e(TAG, "hibernate: dir is empty");
    }

    public void commit(BaseBean baseBean, Boolean bool) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 4)) {
            iPatchRedirector.redirect((short) 4, (Object) this, (Object) baseBean, (Object) bool);
        } else if (this.enable && this.ioHandler != null) {
            this.ioHandler.post(new Runnable(baseBean, bool) { // from class: com.tencent.camerasdk.avreport.AVReportCenter.2
                static IPatchRedirector $redirector_;
                final /* synthetic */ BaseBean val$bean;
                final /* synthetic */ Boolean val$explicit;

                {
                    this.val$bean = baseBean;
                    this.val$explicit = bool;
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                        iPatchRedirector2.redirect((short) 1, this, AVReportCenter.this, baseBean, bool);
                    }
                }

                @Override // java.lang.Runnable
                public void run() {
                    IPatchRedirector iPatchRedirector2 = $redirector_;
                    if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                        iPatchRedirector2.redirect((short) 2, (Object) this);
                        return;
                    }
                    if (AVReportCenter.this.reporter == null) {
                        AVReportCenter.this.reporter = new Reporter(new File(AVReportCenter.this.dir), AVReportCenter.this.auto);
                    }
                    HashMap<String, Object> extractReportData = this.val$bean.extractReportData(this.val$explicit);
                    extractReportData.put("device", DeviceInfo.getBrand() + " + " + DeviceInfo.getDeviceName());
                    extractReportData.put("device_id", AVReportCenter.this.imei);
                    extractReportData.put("platform", "and");
                    extractReportData.put("os", AVReportCenter.this.f99066os);
                    extractReportData.put("appid", AVReportCenter.this.app);
                    extractReportData.put("_dc", Integer.valueOf(Math.abs(new Random().nextInt())));
                    AVReportCenter.this.hibernate(AVReportCenter.toUrlParams(extractReportData));
                }
            });
        }
    }
}
