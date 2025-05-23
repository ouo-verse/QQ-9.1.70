package oicq.wlogin_sdk.report;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.thread.monitor.plugin.proxy.BaseHandlerThread;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import oicq.wlogin_sdk.listener.ReportListener;
import oicq.wlogin_sdk.report.a;
import oicq.wlogin_sdk.report.event.EventSaver;
import oicq.wlogin_sdk.request.u;
import oicq.wlogin_sdk.tools.util;

/* compiled from: P */
/* loaded from: classes28.dex */
public class b implements Handler.Callback {

    /* renamed from: a, reason: collision with root package name */
    public HandlerThread f422850a;

    /* renamed from: b, reason: collision with root package name */
    public Handler f422851b;

    /* renamed from: c, reason: collision with root package name */
    public ReportListener f422852c = null;

    /* renamed from: d, reason: collision with root package name */
    public final EventSaver f422853d = new EventSaver();

    /* compiled from: P */
    /* loaded from: classes28.dex */
    public static final class a {

        /* renamed from: a, reason: collision with root package name */
        public static final b f422854a = new b();
    }

    public b() {
        BaseHandlerThread baseHandlerThread = new BaseHandlerThread("CostTracer");
        this.f422850a = baseHandlerThread;
        try {
            baseHandlerThread.start();
            if (this.f422850a.isAlive()) {
                this.f422851b = new Handler(this.f422850a.getLooper(), this);
            }
        } catch (Throwable unused) {
        }
    }

    public static void a() {
        Handler handler = a.f422854a.f422851b;
        if (handler != null) {
            handler.sendEmptyMessage(2);
        }
    }

    @Override // android.os.Handler.Callback
    public boolean handleMessage(Message message) {
        ReportListener reportListener;
        String str;
        int i3 = message.what;
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 != 3) {
                    if (i3 == 4) {
                        oicq.wlogin_sdk.report.c.a aVar = (oicq.wlogin_sdk.report.c.a) message.obj;
                        if (aVar != null) {
                            try {
                                this.f422853d.realSaveItem(u.f422949w, aVar.f422855a, aVar.f422857c);
                            } catch (Exception e16) {
                                str = util.LOG_TAG_EVENT_REPORT + Log.getStackTraceString(e16);
                            }
                        } else {
                            str = util.LOG_TAG_EVENT_REPORT + "saveEvent error ,saveEvent = null";
                        }
                        util.LOGI(str, "");
                    }
                } else {
                    oicq.wlogin_sdk.report.c.a aVar2 = (oicq.wlogin_sdk.report.c.a) message.obj;
                    if (aVar2 != null && (reportListener = this.f422852c) != null) {
                        reportListener.onReport(aVar2.f422855a, aVar2.f422861g, aVar2.f422858d, aVar2.f422859e);
                    }
                }
            } else if (u.f422949w != null) {
                oicq.wlogin_sdk.report.a aVar3 = a.b.f422849a;
                Context context = u.f422949w;
                aVar3.getClass();
                util.LOGI("saveCost " + aVar3.f422841a.size(), "");
                if (aVar3.f422841a.size() > 0) {
                    ArrayList arrayList = new ArrayList(aVar3.f422841a.size());
                    arrayList.addAll(aVar3.f422841a);
                    aVar3.f422841a.clear();
                    StringBuilder sb5 = new StringBuilder(100);
                    String str2 = util.get_cost_time(context);
                    if (!TextUtils.isEmpty(str2)) {
                        sb5.append(str2);
                    }
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        a.C10917a c10917a = (a.C10917a) it.next();
                        sb5.append(c10917a.f422844b);
                        sb5.append("|");
                        sb5.append(c10917a.f422843a);
                        sb5.append("|");
                        sb5.append(c10917a.f422845c);
                        sb5.append("|");
                        sb5.append(c10917a.f422846d);
                        sb5.append("|");
                        sb5.append(c10917a.f422847e);
                        sb5.append(";");
                    }
                    util.save_cost_time(context, sb5.toString());
                    if (aVar3.f422842b.size() > 0) {
                        ArrayList arrayList2 = new ArrayList(aVar3.f422842b.size());
                        arrayList2.addAll(aVar3.f422842b);
                        aVar3.f422842b.clear();
                        StringBuilder sb6 = new StringBuilder(100);
                        String str3 = util.get_cost_trace(context);
                        if (!TextUtils.isEmpty(str3)) {
                            sb6.append(str3);
                        }
                        Iterator it5 = arrayList2.iterator();
                        while (it5.hasNext()) {
                            a.C10917a c10917a2 = (a.C10917a) it5.next();
                            sb6.append(c10917a2.f422844b);
                            sb6.append(",");
                            sb6.append(c10917a2.f422848f);
                            sb6.append("|");
                        }
                        util.save_cost_trace(context, sb6.toString());
                    }
                }
            }
        } else {
            Thread thread = (Thread) message.obj;
            for (Map.Entry<Thread, StackTraceElement[]> entry : Thread.getAllStackTraces().entrySet()) {
                Thread key = entry.getKey();
                StackTraceElement[] value = entry.getValue();
                if (key == thread) {
                    StringBuilder sb7 = new StringBuilder("    ");
                    for (int i16 = 0; i16 < value.length; i16++) {
                        sb7.append(value[i16].getClassName() + ".");
                        sb7.append(value[i16].getMethodName() + "(");
                        sb7.append(value[i16].getFileName() + ":");
                        sb7.append(value[i16].getLineNumber() + ")");
                        sb7.append("\n");
                    }
                    oicq.wlogin_sdk.report.a aVar4 = a.b.f422849a;
                    String sb8 = sb7.toString();
                    aVar4.getClass();
                    a.C10917a c10917a3 = new a.C10917a();
                    c10917a3.f422844b = System.currentTimeMillis();
                    c10917a3.f422848f = sb8;
                    aVar4.f422842b.add(c10917a3);
                }
            }
        }
        return true;
    }
}
