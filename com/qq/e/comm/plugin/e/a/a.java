package com.qq.e.comm.plugin.e.a;

import android.util.Pair;
import com.qq.e.comm.plugin.stat.StatTracer;
import com.qq.e.comm.util.GDTLogger;
import com.tencent.imsdk.BaseConstants;

/* compiled from: P */
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    private a f39344a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f39344a = aVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Object b(int i3, boolean z16) {
        Object obj;
        try {
            Pair<Boolean, Object> d16 = d(i3, z16);
            if (d16 != null && (obj = d16.first) != null && ((Boolean) obj).booleanValue()) {
                return d16.second;
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        a aVar = this.f39344a;
        if (aVar != null) {
            return aVar.b(i3, z16);
        }
        a(80102, i3);
        return null;
    }

    protected abstract Pair<Boolean, Boolean> c(int i3, boolean z16) throws Throwable;

    protected abstract Pair<Boolean, Object> d(int i3, boolean z16) throws Throwable;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a a() {
        return this.f39344a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public boolean a(int i3, boolean z16) {
        Object obj;
        Object obj2;
        try {
            Pair<Boolean, Boolean> c16 = c(i3, z16);
            if (c16 != null && (obj = c16.first) != null && ((Boolean) obj).booleanValue() && (obj2 = c16.second) != null) {
                return ((Boolean) obj2).booleanValue();
            }
        } catch (Throwable th5) {
            GDTLogger.e(th5.getMessage());
        }
        a aVar = this.f39344a;
        if (aVar != null) {
            return aVar.a(i3, z16);
        }
        a(BaseConstants.ERR_REQ_CONTENT_ATTACK, i3);
        return false;
    }

    void a(int i3, int i16) {
        com.qq.e.comm.plugin.stat.b bVar = new com.qq.e.comm.plugin.stat.b();
        com.qq.e.comm.plugin.stat.c cVar = new com.qq.e.comm.plugin.stat.c();
        cVar.a("error_code", Integer.valueOf(i16));
        StatTracer.trackEvent(i3, 0, bVar, cVar);
    }
}
