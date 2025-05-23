package com.tencent.mobileqq.app.memory;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import com.tencent.mobileqq.qfix.redirect.PatchRedirectCenter;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes11.dex */
public class QLogReporter {
    static IPatchRedirector $redirector_;

    /* renamed from: a, reason: collision with root package name */
    static final SimpleDateFormat f195831a;

    /* renamed from: b, reason: collision with root package name */
    private static volatile QLogReporter f195832b;

    static {
        IPatchRedirector redirector = PatchRedirectCenter.getRedirector(70316);
        $redirector_ = redirector;
        if (redirector != null && redirector.hasPatch((short) 3)) {
            redirector.redirect((short) 3);
        } else {
            f195831a = new SimpleDateFormat("yy.MM.dd");
            f195832b = null;
        }
    }

    public QLogReporter() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, (Object) this);
        }
    }

    public static QLogReporter a() {
        if (f195832b == null) {
            synchronized (QLogReporter.class) {
                if (f195832b == null) {
                    f195832b = new QLogReporter();
                }
            }
        }
        return f195832b;
    }

    public void b() {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            iPatchRedirector.redirect((short) 2, (Object) this);
            return;
        }
        if (new GregorianCalendar().get(11) < 2) {
            return;
        }
        SharedPreferences sharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("qlog_reporter", 0);
        long currentTimeMillis = System.currentTimeMillis();
        long j3 = sharedPreferences.getLong("LastLogSizeReportTime", 0L);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        SimpleDateFormat simpleDateFormat = f195831a;
        String format = simpleDateFormat.format(calendar.getTime());
        calendar.setTimeInMillis(currentTimeMillis);
        if (format.equals(simpleDateFormat.format(calendar.getTime()))) {
            return;
        }
        ThreadManagerV2.executeOnSubThread(new Runnable(sharedPreferences, currentTimeMillis) { // from class: com.tencent.mobileqq.app.memory.QLogReporter.1
            static IPatchRedirector $redirector_;

            /* renamed from: d, reason: collision with root package name */
            final /* synthetic */ SharedPreferences f195833d;

            /* renamed from: e, reason: collision with root package name */
            final /* synthetic */ long f195834e;

            {
                this.f195833d = sharedPreferences;
                this.f195834e = currentTimeMillis;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 1)) {
                    iPatchRedirector2.redirect((short) 1, this, QLogReporter.this, sharedPreferences, Long.valueOf(currentTimeMillis));
                }
            }

            @Override // java.lang.Runnable
            public void run() {
                String[] list;
                IPatchRedirector iPatchRedirector2 = $redirector_;
                if (iPatchRedirector2 != null && iPatchRedirector2.hasPatch((short) 2)) {
                    iPatchRedirector2.redirect((short) 2, (Object) this);
                    return;
                }
                try {
                    String str = QLog.getLogExternalPath(BaseApplication.context) + "/tencent/msflogs/" + "com.tencent.mobileqq".replace(".", "/") + "/";
                    File file = new File(str);
                    if (file.exists() && file.isDirectory() && (list = file.list()) != null && list.length != 0) {
                        long currentTimeMillis2 = System.currentTimeMillis() - 86400000;
                        Calendar calendar2 = Calendar.getInstance();
                        calendar2.setTimeInMillis(currentTimeMillis2);
                        SimpleDateFormat simpleDateFormat2 = QLogReporter.f195831a;
                        String format2 = simpleDateFormat2.format(calendar2.getTime());
                        calendar2.setTimeInMillis(currentTimeMillis2 - 86400000);
                        String format3 = simpleDateFormat2.format(calendar2.getTime());
                        for (int i3 = 0; i3 < list.length; i3++) {
                            String str2 = list[i3];
                            if (i3 != list.length - 1) {
                                if (str2.contains(format3)) {
                                    break;
                                }
                            } else if (!str2.contains(format3)) {
                                SharedPreferences.Editor edit = this.f195833d.edit();
                                edit.putLong("LastLogSizeReportTime", this.f195834e);
                                edit.commit();
                                return;
                            }
                        }
                        HashMap hashMap = new HashMap();
                        for (String str3 : list) {
                            if (str3.contains(format2) && str3.contains("com.tencent.mobileqq")) {
                                if (str3.endsWith(".log")) {
                                    return;
                                }
                                if (!str3.contains("_")) {
                                    List list2 = (List) hashMap.get("com.tencent.mobileqq");
                                    if (list2 == null) {
                                        list2 = new LinkedList();
                                        hashMap.put("com.tencent.mobileqq", list2);
                                    }
                                    list2.add(str3);
                                } else {
                                    String[] split = str3.split("\\.");
                                    int length = split.length;
                                    int i16 = 0;
                                    while (true) {
                                        if (i16 < length) {
                                            String str4 = split[i16];
                                            if (str4.contains("_")) {
                                                String str5 = "com.tencent." + str4;
                                                List list3 = (List) hashMap.get(str5);
                                                if (list3 == null) {
                                                    list3 = new LinkedList();
                                                    hashMap.put(str5, list3);
                                                }
                                                list3.add(str3);
                                            } else {
                                                i16++;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        HashMap<String, String> hashMap2 = new HashMap<>();
                        for (Map.Entry entry : hashMap.entrySet()) {
                            Iterator it = ((List) entry.getValue()).iterator();
                            long j16 = 0;
                            while (it.hasNext()) {
                                File file2 = new File(str, (String) it.next());
                                if (file2.exists() && !file2.isDirectory()) {
                                    j16 += file2.length();
                                }
                            }
                            hashMap2.put((String) entry.getKey(), String.valueOf(j16));
                            QLog.i("QLogReporter", 1, ((String) entry.getKey()) + " Yesterday log size is " + j16);
                        }
                        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance("", "YesterdayLogSizeCollection", true, 0L, 0L, hashMap2, "");
                        SharedPreferences.Editor edit2 = this.f195833d.edit();
                        edit2.putLong("LastLogSizeReportTime", this.f195834e);
                        edit2.commit();
                    }
                } catch (Exception e16) {
                    e16.printStackTrace();
                }
            }
        });
    }
}
