package com.tencent.mobileqq.qfix.redirect.field;

import com.tencent.mobileqq.qfix.redirect.field.GCMonitor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes16.dex */
public class PatchFieldPool implements GCMonitor.GCMonitorListener {

    /* renamed from: d, reason: collision with root package name */
    private static PatchFieldPool f261895d;

    /* renamed from: a, reason: collision with root package name */
    final Map<String, List<PatchField>> f261896a = new HashMap();

    /* renamed from: b, reason: collision with root package name */
    final Map<String, PatchField> f261897b = new HashMap();

    /* renamed from: c, reason: collision with root package name */
    final GCMonitor f261898c = new GCMonitor(this);

    PatchFieldPool() {
    }

    public static PatchFieldPool b() {
        if (f261895d == null) {
            synchronized (PatchFieldPool.class) {
                if (f261895d == null) {
                    f261895d = new PatchFieldPool();
                }
            }
        }
        return f261895d;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final PatchField a(String str, Object obj) {
        List<PatchField> list = this.f261896a.get(str);
        if (list == null || list.isEmpty()) {
            return null;
        }
        for (PatchField patchField : list) {
            if (patchField.a(obj)) {
                return patchField;
            }
        }
        return null;
    }

    public final Object a(String str, Object obj, String str2) {
        Object obj2;
        String a16 = PatchField.a(false, str, obj, str2);
        synchronized (this.f261896a) {
            PatchField a17 = a(a16, obj);
            obj2 = a17 == null ? null : a17.f261893c;
        }
        return obj2;
    }

    public final Object a(String str, String str2) {
        Object obj = null;
        String a16 = PatchField.a(true, str, null, str2);
        synchronized (this.f261897b) {
            PatchField patchField = this.f261897b.get(a16);
            if (patchField != null) {
                obj = patchField.f261893c;
            }
        }
        return obj;
    }

    @Override // com.tencent.mobileqq.qfix.redirect.field.GCMonitor.GCMonitorListener
    public final void a() {
        synchronized (this.f261896a) {
            ArrayList arrayList = new ArrayList();
            for (String str : this.f261896a.keySet()) {
                ArrayList arrayList2 = new ArrayList();
                List<PatchField> list = this.f261896a.get(str);
                if (list != null && !list.isEmpty()) {
                    for (PatchField patchField : list) {
                        if (!patchField.f261891a && patchField.f261892b.get() == null) {
                            arrayList2.add(patchField);
                            LogUtils.a();
                        }
                    }
                }
                if (!arrayList2.isEmpty()) {
                    list.removeAll(arrayList2);
                }
                if (list == null || list.isEmpty()) {
                    arrayList.add(str);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.f261896a.remove((String) it.next());
            }
        }
    }
}
