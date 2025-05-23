package com.tencent.tav.report;

import com.tencent.tav.decoder.logger.Logger;
import java.lang.reflect.Field;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes26.dex */
public class ReportBean {
    private static final String TAG = "ReportBean";

    @ReportField
    public String event;

    @ReportField
    public String service;

    @ReportField
    public Long timestamp = 0L;

    @ReportField
    public String version;

    public ReportBean(String str, String str2, String str3) {
        this.service = str;
        this.event = str2;
        this.version = str3;
    }

    private void putFieldToMap(String str, Field field, HashMap<String, String> hashMap) {
        try {
            hashMap.put(str, String.valueOf(field.get(this)));
        } catch (IllegalAccessException e16) {
            Logger.w(TAG, "extractReportData: " + e16);
        }
    }

    public HashMap<String, String> extractReportData() {
        return extractReportData(Boolean.FALSE);
    }

    public HashMap<String, String> extractReportData(Boolean bool) {
        HashMap<String, String> hashMap = new HashMap<>();
        for (Field field : getClass().getSuperclass().getDeclaredFields()) {
            if (field.isAnnotationPresent(ReportField.class)) {
                putFieldToMap(field.getName(), field, hashMap);
            }
        }
        for (Field field2 : getClass().getDeclaredFields()) {
            if (!bool.booleanValue() || field2.isAnnotationPresent(ReportField.class)) {
                ReportKey reportKey = (ReportKey) field2.getAnnotation(ReportKey.class);
                String name = reportKey == null ? field2.getName() : reportKey.name();
                boolean z16 = !field2.isAccessible();
                if (z16) {
                    field2.setAccessible(true);
                }
                putFieldToMap(name, field2, hashMap);
                if (z16) {
                    field2.setAccessible(false);
                }
            }
        }
        return hashMap;
    }
}
