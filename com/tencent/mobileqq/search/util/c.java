package com.tencent.mobileqq.search.util;

import com.tencent.mobileqq.R;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.tuxmeterqui.timepicker.TuxDateStringUtils;
import java.text.SimpleDateFormat;

/* compiled from: P */
/* loaded from: classes18.dex */
public class c {

    /* renamed from: a, reason: collision with root package name */
    public static final String f285032a = HardCodeUtil.qqStr(R.string.l_0);

    /* renamed from: b, reason: collision with root package name */
    public static final String f285033b = HardCodeUtil.qqStr(R.string.l_q);

    /* renamed from: c, reason: collision with root package name */
    public static final String f285034c = HardCodeUtil.qqStr(R.string.l9z);

    /* renamed from: d, reason: collision with root package name */
    public static final String f285035d = HardCodeUtil.qqStr(R.string.l9y);

    public static String a(long j3) {
        long currentTimeMillis = (System.currentTimeMillis() / 1000) - j3;
        if (currentTimeMillis >= 0 && currentTimeMillis < 60) {
            return f285032a;
        }
        if (currentTimeMillis >= 60 && currentTimeMillis < 3600) {
            return (currentTimeMillis / 60) + f285033b;
        }
        if (currentTimeMillis >= 3600 && currentTimeMillis < 86400) {
            return (currentTimeMillis / 3600) + f285034c;
        }
        if (currentTimeMillis >= 86400 && currentTimeMillis < 432000) {
            return (currentTimeMillis / 86400) + f285035d;
        }
        return new SimpleDateFormat(TuxDateStringUtils.TUX_COMMON_DATE_FORMAT).format(Long.valueOf(j3 * 1000));
    }
}
