package ow0;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes7.dex */
public class a {

    /* compiled from: P */
    /* renamed from: ow0.a$a, reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C10963a {

        /* renamed from: a, reason: collision with root package name */
        public String f424211a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f424212b;
    }

    public static C10963a a(String str) {
        C10963a c10963a = new C10963a();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            try {
                String[] split = str.trim().split("\\?");
                if (split == null) {
                    return c10963a;
                }
                c10963a.f424211a = split[0];
                if (split.length == 1) {
                    return c10963a;
                }
                String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
                c10963a.f424212b = new HashMap();
                for (String str2 : split2) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3 != null && split3.length == 2) {
                        c10963a.f424212b.put(split3[0], split3[1]);
                    }
                }
            } catch (Exception e16) {
                QLog.e("ICGameUrlParseUtil", 1, e16.toString());
            }
        }
        return c10963a;
    }
}
