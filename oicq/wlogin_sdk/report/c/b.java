package oicq.wlogin_sdk.report.c;

import android.os.Handler;
import android.os.Message;
import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.smtt.sdk.stat.MttLoader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import oicq.wlogin_sdk.report.b;
import oicq.wlogin_sdk.report.event.EventConstant;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b {

    /* renamed from: a, reason: collision with root package name */
    public static String f422862a;

    /* renamed from: b, reason: collision with root package name */
    public static SimpleDateFormat f422863b = new SimpleDateFormat("yy-MM-dd HH:mm:ss");

    public static void a(a aVar, int i3) {
        if (new Random().nextInt(i3) < 1) {
            a(aVar);
        }
    }

    public static void a(a aVar) {
        String format = f422863b.format(new Date());
        String valueOf = String.valueOf(util.SVN_VER);
        if (f422862a == null) {
            f422862a = u.f();
        }
        StringBuilder sb5 = new StringBuilder(util.LOG_TAG_EVENT_REPORT);
        sb5.append(",type=");
        sb5.append(aVar.f422855a);
        sb5.append(",subType=");
        sb5.append(aVar.f422856b);
        sb5.append(",detail=");
        sb5.append(aVar.f422857c);
        sb5.append(",isRealTime=");
        sb5.append(aVar.f422858d);
        sb5.append(",isImmediatelyUpload=");
        sb5.append(aVar.f422859e);
        sb5.append(",uin=");
        sb5.append(aVar.f422860f);
        sb5.append(",time=");
        sb5.append(format);
        sb5.append(MttLoader.QQBROWSER_PARAMS_VERSION);
        sb5.append(valueOf);
        sb5.append(",process=");
        sb5.append(f422862a);
        sb5.append(",isReportAtta=");
        sb5.append(false);
        HashMap<String, String> hashMap = aVar.f422861g;
        if (!hashMap.isEmpty()) {
            for (Map.Entry<String, String> entry : hashMap.entrySet()) {
                sb5.append(",");
                sb5.append(entry.getKey());
                sb5.append(ContainerUtils.KEY_VALUE_DELIMITER);
                sb5.append(entry.getValue());
            }
        }
        hashMap.put("user_id", aVar.f422860f);
        hashMap.put("sub_type", aVar.f422856b);
        hashMap.put("detail", aVar.f422857c);
        hashMap.put(EventConstant.EventParams.WT_VERSION, valueOf);
        hashMap.put(EventConstant.EventParams.HAPPEN_TIME, format);
        hashMap.put("process", f422862a);
        hashMap.put(EventConstant.EventParams.IS_NT_RUNNING, String.valueOf(util.getNTSwitch(u.f422949w)));
        oicq.wlogin_sdk.report.b bVar = b.a.f422854a;
        Handler handler = bVar.f422851b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = aVar;
            bVar.f422851b.sendMessage(obtainMessage);
        }
        util.LOGI(sb5.toString(), "");
    }
}
