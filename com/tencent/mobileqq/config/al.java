package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.config.business.QConfLogProcessor;
import java.util.Set;

/* compiled from: P */
/* loaded from: classes10.dex */
public class al {
    private static ai[] a(int i3, BaseApplicationImpl baseApplicationImpl) {
        SharedPreferences c16 = c(0L, baseApplicationImpl);
        SharedPreferences b16 = b(0L, baseApplicationImpl);
        Set<String> stringSet = c16.getStringSet(i3 + "_ids", null);
        if (stringSet == null || stringSet.isEmpty()) {
            return null;
        }
        ai[] aiVarArr = new ai[stringSet.size()];
        int i16 = 0;
        for (String str : stringSet) {
            aiVarArr[i16] = new ai(Integer.valueOf(str).intValue(), b16.getString(i3 + "_" + str, null));
            i16++;
        }
        return aiVarArr;
    }

    private static SharedPreferences b(long j3, BaseApplicationImpl baseApplicationImpl) {
        return baseApplicationImpl.getSystemSharedPreferences("conf_" + j3 + "_content_sharepref", 4);
    }

    private static SharedPreferences c(long j3, BaseApplicationImpl baseApplicationImpl) {
        return baseApplicationImpl.getSystemSharedPreferences("conf_" + j3 + "_sharepref", 4);
    }

    public static com.tencent.mobileqq.config.business.aw d(BaseApplicationImpl baseApplicationImpl) {
        ak.b().g(419, 0L, false);
        QConfLogProcessor qConfLogProcessor = new QConfLogProcessor();
        ai[] a16 = a(419, baseApplicationImpl);
        if (a16 != null) {
            try {
                com.tencent.mobileqq.config.business.aw onParsed = qConfLogProcessor.onParsed(a16);
                if (onParsed != null) {
                    return onParsed;
                }
            } catch (Exception unused) {
            }
        }
        return new com.tencent.mobileqq.config.business.aw();
    }
}
