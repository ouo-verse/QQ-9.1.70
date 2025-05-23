package com.qq.e.comm.plugin.base.ad.c;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONArray;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private a f38470a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f38470a = aVar;
    }

    protected abstract void b(JSONArray jSONArray, String str);

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        return this.f38470a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(JSONArray jSONArray, String str) {
        GDTLogger.d(getClass().getSimpleName() + " preload");
        b(jSONArray, str);
        if (this.f38470a != null) {
            GDTLogger.d("next is " + this.f38470a.getClass().getSimpleName());
            this.f38470a.a(jSONArray, str);
        }
    }
}
