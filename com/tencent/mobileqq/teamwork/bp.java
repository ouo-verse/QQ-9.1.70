package com.tencent.mobileqq.teamwork;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.mobileqq.config.business.tendoc.TencentDocImportFileInfoProcessor;
import java.util.HashMap;

/* compiled from: P */
/* loaded from: classes18.dex */
public class bp {

    /* renamed from: b, reason: collision with root package name */
    private static volatile bp f292114b;

    /* renamed from: a, reason: collision with root package name */
    public String f292115a = "doc|.docx|.xls|.xlsx";

    public static HashMap<String, String> a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        HashMap<String, String> hashMap = new HashMap<>();
        String[] split = str.split(ContainerUtils.FIELD_DELIMITER);
        if (split != null && split.length > 0) {
            for (String str2 : split) {
                String[] split2 = str2.split("_");
                if (split2 != null && split2.length == 2 && !TextUtils.isEmpty(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                    hashMap.put(split2[0], split2[1]);
                }
            }
        }
        return hashMap;
    }

    public static bp b() {
        if (f292114b == null) {
            synchronized (bp.class) {
                if (f292114b == null) {
                    f292114b = new bp();
                }
            }
        }
        return f292114b;
    }

    public void c() {
        String e16 = TencentDocImportFileInfoProcessor.c().e();
        if (!TextUtils.isEmpty(e16)) {
            this.f292115a = e16;
        }
    }
}
