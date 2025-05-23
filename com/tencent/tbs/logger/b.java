package com.tencent.tbs.logger;

import android.os.Process;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* compiled from: P */
/* loaded from: classes26.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    private static final DateFormat f374481a = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINA);

    public static String a(c cVar) {
        if (cVar == null) {
            return "";
        }
        return f374481a.format(new Date(cVar.f374482a)) + " " + Process.myPid() + "-" + Process.myTid() + " " + LogLevel.getShortName(cVar.f374483b) + "/" + cVar.f374484c + MsgSummary.STR_COLON + cVar.f374485d + "\n";
    }
}
