package com.huawei.hms.common.internal;

import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.StringUtil;
import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes2.dex */
public class TransactionIdCreater {
    private static SecureRandom a() {
        try {
            return SecureRandom.getInstance("SHA1PRNG");
        } catch (Exception unused) {
            HMSLog.e("TransactionIdCreater", "SecureRandom getInstance happpened NoSuchAlgorithmException!");
            return new SecureRandom();
        }
    }

    public static String getId(String str, String str2) {
        StringBuilder sb5 = new StringBuilder();
        sb5.append(StringUtil.addByteForNum(str, 9, '0'));
        sb5.append(StringUtil.addByteForNum(str2, 6, '0'));
        Locale locale = Locale.ENGLISH;
        sb5.append(new SimpleDateFormat("yyyyMMddHHmmssSSS", locale).format(new Date()));
        sb5.append(String.format(locale, "%06d", Integer.valueOf(a().nextInt(1000000))));
        return sb5.toString();
    }
}
