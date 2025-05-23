package com.tencent.mobileqq.ark.module;

import android.app.Activity;
import android.text.TextUtils;
import com.tencent.ark.ark;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import mqq.app.Foreground;

/* compiled from: P */
/* loaded from: classes11.dex */
public abstract class b implements ark.ModuleCallbackWrapper {

    /* renamed from: k, reason: collision with root package name */
    public static boolean f199564k = true;

    /* renamed from: a, reason: collision with root package name */
    protected int f199565a;

    /* renamed from: b, reason: collision with root package name */
    protected String f199566b;

    /* renamed from: c, reason: collision with root package name */
    protected String f199567c;

    /* renamed from: d, reason: collision with root package name */
    protected String f199568d;

    /* renamed from: e, reason: collision with root package name */
    protected String f199569e;

    /* renamed from: f, reason: collision with root package name */
    protected ark.Application f199570f;

    /* renamed from: g, reason: collision with root package name */
    private long f199571g = 1;

    /* renamed from: h, reason: collision with root package name */
    private final HashMap<Long, ark.VariantWrapper> f199572h = new HashMap<>();

    /* renamed from: i, reason: collision with root package name */
    private final Map<String, Set<j>> f199573i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    private final HashMap<String, e> f199574j = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: protected */
    public b(ark.Application application, int i3) {
        this.f199565a = 0;
        this.f199566b = null;
        this.f199567c = null;
        this.f199569e = null;
        this.f199570f = null;
        this.f199570f = application;
        this.f199566b = application.GetSpecific("appName");
        this.f199568d = application.GetSpecific(ark.APP_SPECIFIC_BIZSRC);
        this.f199569e = application.GetSpecific(ark.APP_SPECIFIC_APPPATH);
        this.f199567c = application.GetID();
        this.f199565a = i3;
        k();
    }

    public static Activity f() {
        QBaseActivity qBaseActivity = QBaseActivity.sTopActivity;
        if (qBaseActivity != null) {
            return qBaseActivity;
        }
        return Foreground.getTopActivity();
    }

    private void k() {
        e[] e16 = e();
        if (e16 != null) {
            for (e eVar : e16) {
                this.f199574j.put(eVar.getMethodName(), eVar);
            }
        }
    }

    @Override // com.tencent.ark.ark.ModuleCallbackWrapper
    public void Destruct() {
        Iterator<Map.Entry<Long, ark.VariantWrapper>> it = this.f199572h.entrySet().iterator();
        while (it.hasNext()) {
            it.next().getValue().Reset();
        }
        this.f199572h.clear();
    }

    @Override // com.tencent.ark.ark.ModuleCallbackWrapper
    public String GetTypeName() {
        return null;
    }

    @Override // com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean HasMethod(String str) {
        e eVar = this.f199574j.get(str);
        if (eVar == null) {
            return false;
        }
        if (!i(eVar)) {
            QLog.i("ArkApp.ArkAppModuleBase", 1, "HasMethod, method not support app type, method=" + eVar);
            return false;
        }
        if (j(eVar)) {
            return true;
        }
        QLog.i("ArkApp.ArkAppModuleBase", 1, "HasMethod, method not support multi process, method=" + eVar);
        return false;
    }

    @Override // com.tencent.ark.ark.ModuleCallbackWrapper
    public boolean Invoke(String str, ark.VariantWrapper[] variantWrapperArr, ark.VariantWrapper variantWrapper) {
        e eVar = this.f199574j.get(str);
        if (eVar == null) {
            return false;
        }
        if (!c(str)) {
            QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, check frequency fail, method=" + str);
            return false;
        }
        if (!b(eVar)) {
            QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, no permission, method=" + str);
            return false;
        }
        if (!h() && !eVar.a()) {
            QLog.i("ArkApp.ArkAppModuleBase", 1, "Invoke, method not support multiprocess, method=" + eVar);
            return false;
        }
        eVar.c(this, variantWrapperArr, variantWrapper);
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void a(String str, long j3, long j16) {
        if (!TextUtils.isEmpty(str) && j16 > 0) {
            if (QLog.isColorLevel()) {
                QLog.i("ArkApp", 2, String.format("ModuleBase.addTokenBucket.api:%s,times:%d,period:%d", str, Long.valueOf(j3), Long.valueOf(j16)));
            }
            Set<j> set = this.f199573i.get(str);
            if (set == null) {
                set = new HashSet<>();
                this.f199573i.put(str, set);
            }
            set.add(new j(j3, j16));
        }
    }

    boolean b(e eVar) {
        return a.a(this.f199566b, this.f199565a, this.f199570f, eVar.getPermission());
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Set<j> set = this.f199573i.get(str);
        if (set != null) {
            for (j jVar : set) {
                if (!jVar.a()) {
                    QLog.i("ArkApp", 2, String.format("ModuleBase.checkFrequency.Refuse:%s,%s ", str, jVar.toString()));
                    return false;
                }
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ark.VariantWrapper d(long j3) {
        return this.f199572h.get(Long.valueOf(j3));
    }

    protected abstract e[] e();

    /* JADX INFO: Access modifiers changed from: protected */
    public long g(ark.VariantWrapper variantWrapper) {
        if (variantWrapper == null || !variantWrapper.IsFunction()) {
            return 0L;
        }
        long j3 = this.f199571g + 1;
        this.f199571g = j3;
        if (j3 == 0) {
            this.f199571g = 1L;
        }
        this.f199572h.put(Long.valueOf(this.f199571g), variantWrapper);
        return this.f199571g;
    }

    boolean h() {
        return com.tencent.mobileqq.ark.util.j.a();
    }

    boolean i(e eVar) {
        if (eVar.b() || this.f199565a == 0) {
            return true;
        }
        return false;
    }

    boolean j(e eVar) {
        if (h()) {
            return true;
        }
        return eVar.a();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public ark.VariantWrapper l(long j3) {
        ark.VariantWrapper variantWrapper = this.f199572h.get(Long.valueOf(j3));
        this.f199572h.remove(Long.valueOf(j3));
        return variantWrapper;
    }

    public void m(List<c91.a> list) {
        if (list != null) {
            for (c91.a aVar : list) {
                a(aVar.f30459a, aVar.f30460b, aVar.f30461c);
            }
        }
    }

    public abstract boolean n();

    public abstract boolean o();
}
