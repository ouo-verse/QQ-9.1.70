package com.tencent.mobileqq.guild.util;

import androidx.room.RoomMasterTable;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.tencent.gamecenter.wadl.biz.entity.WadlProxyConsts;
import com.tenpay.ErrorCode;
import common.config.service.QzoneConfig;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/* compiled from: P */
/* loaded from: classes14.dex */
public class cr {

    /* renamed from: a, reason: collision with root package name */
    public static String[] f235533a = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};

    /* renamed from: b, reason: collision with root package name */
    public static String[] f235534b = {"00", HiAnalyticsConstant.KeyAndValue.NUMBER_01, "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31", "32", WadlProxyConsts.OPER_TYPE_APK_SIGN, WadlProxyConsts.OPER_TYPE_MONITOR, "35", "36", "37", "38", "39", "40", "41", RoomMasterTable.DEFAULT_ID, "43", "44", "45", "46", "47", "48", "49", "50", "51", QzoneConfig.DefaultValue.DEFAULT_MODEL_PHONE, "53", "54", "55", "56", "57", "58", ErrorCode.ERR_NET};

    public static String a(long j3) {
        Date date;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(j3);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy\u5e74MM\u6708dd\u65e5 E HH:mm");
        try {
            date = calendar.getTime();
        } catch (IllegalArgumentException unused) {
            date = new Date();
        }
        return simpleDateFormat.format(date);
    }
}
