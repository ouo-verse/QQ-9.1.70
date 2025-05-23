package com.tencent.mobileqq.qfix.redirect.field;

import androidx.annotation.Keep;
import com.tencent.mobileqq.qfix.redirect.field.GCMonitor;
import com.tencent.thread.monitor.plugin.proxy.BaseThread;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes16.dex */
public class PatchFieldRedirect {
    @Keep
    public static Object getField(Object obj, String str) {
        String[] split = str.split("#");
        return getField(obj, split[0], split[1]);
    }

    @Keep
    public static Object getStaticField(String str) {
        String[] split = str.split("#");
        return getStaticField(split[0], split[1]);
    }

    @Keep
    public static void setField(Object obj, Object obj2, String str, String str2) {
        PatchFieldPool b16 = PatchFieldPool.b();
        String a16 = PatchField.a(false, str, obj, str2);
        synchronized (b16.f261896a) {
            PatchField a17 = b16.a(a16, obj);
            if (a17 == null) {
                List<PatchField> list = b16.f261896a.get(a16);
                if (list == null) {
                    list = new ArrayList<>();
                    b16.f261896a.put(a16, list);
                }
                PatchField patchField = new PatchField(false, str, obj, str2, obj2);
                list.add(patchField);
                patchField.toString();
                LogUtils.a();
                GCMonitor gCMonitor = b16.f261898c;
                synchronized (gCMonitor) {
                    if (!gCMonitor.f261887b.contains(new GCMonitor.GCReference(obj))) {
                        gCMonitor.f261887b.add(new GCMonitor.GCReference(obj, gCMonitor.f261886a));
                        if (!gCMonitor.f261888c) {
                            BaseThread baseThread = new BaseThread(new Runnable() { // from class: com.tencent.mobileqq.qfix.redirect.field.GCMonitor.1
                                public AnonymousClass1() {
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    GCMonitor.a(GCMonitor.this);
                                }
                            }, "gc-monitor-thread");
                            baseThread.setDaemon(true);
                            baseThread.start();
                            gCMonitor.f261888c = true;
                            LogUtils.a();
                        }
                    }
                }
            } else {
                a17.f261893c = obj2;
                a17.toString();
                LogUtils.a();
            }
        }
    }

    @Keep
    public static void setStaticField(Object obj, String str, String str2) {
        PatchFieldPool b16 = PatchFieldPool.b();
        String a16 = PatchField.a(true, str, null, str2);
        synchronized (b16.f261897b) {
            PatchField patchField = b16.f261897b.get(a16);
            if (patchField == null) {
                PatchField patchField2 = new PatchField(true, str, null, str2, obj);
                b16.f261897b.put(a16, patchField2);
                patchField2.toString();
            } else {
                patchField.f261893c = obj;
                patchField.toString();
            }
            LogUtils.a();
        }
    }

    @Keep
    public static Object getField(Object obj, String str, String str2) {
        return PatchFieldPool.b().a(str, obj, str2);
    }

    @Keep
    public static Object getStaticField(String str, String str2) {
        return PatchFieldPool.b().a(str, str2);
    }
}
