package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public class e extends a {

    /* renamed from: a, reason: collision with root package name */
    private a f38478a;

    public void b(a aVar) {
        if (aVar == null) {
            GDTLogger.e("addPreloader error preloader is null");
            return;
        }
        a aVar2 = this.f38478a;
        if (aVar2 == null) {
            GDTLogger.d("firstPreloader == null add newPreloader" + aVar.getClass().getSimpleName());
            this.f38478a = aVar;
            return;
        }
        int i3 = 0;
        while (true) {
            if (i3 >= 50) {
                aVar2 = null;
                break;
            } else {
                if (aVar2.a() == null) {
                    break;
                }
                aVar2 = aVar2.a();
                i3++;
            }
        }
        if (aVar2 != null) {
            GDTLogger.d("add newPreloader" + aVar.getClass().getSimpleName());
            aVar2.a(aVar);
        }
    }

    @Override // com.qq.e.comm.plugin.base.ad.c.a
    protected void b(JSONArray jSONArray, String str) {
        a aVar = this.f38478a;
        if (aVar == null) {
            GDTLogger.e("preload error firstPreloader is null");
        } else {
            aVar.a(jSONArray, str);
        }
    }
}
