package oicq.wlogin_sdk.report.event;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import oicq.wlogin_sdk.persistence.c;
import oicq.wlogin_sdk.persistence.d;
import oicq.wlogin_sdk.report.b;
import oicq.wlogin_sdk.report.c.a;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class EventSaver {
    public static final String EVENT_ITEM_SPLIT = ";";
    public static final String WLOGIN_SP_EVENT = "WLOGIN_EVENT";

    public static void saveEvent(a aVar) {
        b bVar = b.a.f422854a;
        Handler handler = bVar.f422851b;
        if (handler != null) {
            Message obtainMessage = handler.obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.obj = aVar;
            bVar.f422851b.sendMessage(obtainMessage);
        }
    }

    public synchronized void realClearEvent(Context context, String str) {
        if (context == null) {
            return;
        }
        d dVar = (d) ((c) oicq.wlogin_sdk.persistence.a.a(context, WLOGIN_SP_EVENT)).edit();
        dVar.putString(str, "");
        dVar.f422793b.commit();
        util.LOGI(util.LOG_TAG_EVENT_REPORT + "realClearEvent eventType=" + str, "");
    }

    public synchronized String realReadEvent(Context context, String str) {
        if (context == null) {
            return "";
        }
        util.LOGI(util.LOG_TAG_EVENT_REPORT + "realReadEvent eventType=" + str, "");
        return ((c) oicq.wlogin_sdk.persistence.a.a(context, WLOGIN_SP_EVENT)).f422789b.getString(str, "");
    }

    public synchronized void realSaveItem(Context context, String str, String str2) {
        if (context != null) {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                c cVar = (c) oicq.wlogin_sdk.persistence.a.a(context, WLOGIN_SP_EVENT);
                String string = cVar.f422789b.getString(str, "");
                if (!TextUtils.isEmpty(string)) {
                    str2 = string + ";" + str2;
                }
                d dVar = (d) cVar.edit();
                dVar.putString(str, str2);
                dVar.f422793b.commit();
                util.LOGI(util.LOG_TAG_EVENT_REPORT + "realSaveItem eventType=" + str + ",eventDetail=" + str2, "");
            }
        }
    }
}
