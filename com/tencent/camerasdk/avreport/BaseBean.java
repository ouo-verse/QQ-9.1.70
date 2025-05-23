package com.tencent.camerasdk.avreport;

import com.tencent.mobileqq.qfix.redirect.IPatchRedirector;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes5.dex */
public class BaseBean {
    static IPatchRedirector $redirector_;

    @ReportField
    public Long avg_cost_time;

    @ReportField
    public int avg_memory_usage;

    @ReportField
    public Long duration;

    @ReportField
    public String event;

    @ReportField
    public int failure_count;

    @ReportField
    public int max_memory_usage;

    @ReportField
    public String service;

    @ReportField
    public int success_count;

    @ReportField
    public Long timestamp;

    @ReportField
    public String version;

    public BaseBean(String str, String str2, String str3) {
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 1)) {
            iPatchRedirector.redirect((short) 1, this, str, str2, str3);
            return;
        }
        this.timestamp = 0L;
        this.duration = 0L;
        this.success_count = 0;
        this.failure_count = 0;
        this.avg_cost_time = 0L;
        this.avg_memory_usage = 0;
        this.max_memory_usage = 0;
        this.service = str;
        this.event = str2;
        this.version = str3;
    }

    public HashMap<String, Object> extractReportData(Boolean bool) {
        String name;
        IPatchRedirector iPatchRedirector = $redirector_;
        if (iPatchRedirector != null && iPatchRedirector.hasPatch((short) 2)) {
            return (HashMap) iPatchRedirector.redirect((short) 2, (Object) this, (Object) bool);
        }
        HashMap<String, Object> hashMap = new HashMap<>();
        for (Field field : getClass().getSuperclass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ReportField.class)) {
                try {
                    hashMap.put(field.getName(), field.get(this));
                } catch (IllegalAccessException e16) {
                    e16.printStackTrace();
                }
            }
        }
        for (Field field2 : getClass().getDeclaredFields()) {
            if (bool.booleanValue() && !field2.isAnnotationPresent(ReportField.class)) {
                ReportKey reportKey = (ReportKey) field2.getAnnotation(ReportKey.class);
                if (reportKey == null) {
                    name = field2.getName();
                } else {
                    name = reportKey.name();
                }
                Boolean valueOf = Boolean.valueOf(!field2.isAccessible());
                if (valueOf.booleanValue()) {
                    field2.setAccessible(true);
                }
                try {
                    hashMap.put(name, field2.get(this));
                } catch (IllegalAccessException e17) {
                    e17.printStackTrace();
                }
                if (valueOf.booleanValue()) {
                    field2.setAccessible(false);
                }
            }
        }
        return hashMap;
    }
}
