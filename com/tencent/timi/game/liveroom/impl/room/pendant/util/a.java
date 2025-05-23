package com.tencent.timi.game.liveroom.impl.room.pendant.util;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

/* compiled from: P */
/* loaded from: classes26.dex */
public class a {

    /* compiled from: P */
    /* renamed from: com.tencent.timi.game.liveroom.impl.room.pendant.util.a$a, reason: collision with other inner class name */
    /* loaded from: classes26.dex */
    public static class C9947a {

        /* renamed from: a, reason: collision with root package name */
        public String f378189a;

        /* renamed from: b, reason: collision with root package name */
        public Map<String, String> f378190b;
    }

    public static C9947a a(String str) {
        C9947a c9947a = new C9947a();
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str.trim())) {
            try {
                String[] split = str.trim().split("\\?");
                if (split == null) {
                    return c9947a;
                }
                c9947a.f378189a = split[0];
                if (split.length == 1) {
                    return c9947a;
                }
                String[] split2 = split[1].split(ContainerUtils.FIELD_DELIMITER);
                c9947a.f378190b = new HashMap();
                for (String str2 : split2) {
                    String[] split3 = str2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                    if (split3 != null && split3.length == 2) {
                        c9947a.f378190b.put(split3[0], split3[1]);
                    }
                }
            } catch (Exception e16) {
                QLog.e("UrlParseUtil", 1, e16.toString());
            }
        }
        return c9947a;
    }
}
