package com.tencent.luggage.wxa.ar;

import java.util.ArrayList;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes8.dex */
public class m0 {

    /* renamed from: a, reason: collision with root package name */
    public String f121742a;

    public final String a() {
        if (this.f121742a == null) {
            return "VersionMatcher";
        }
        return "VersionMatcher(" + this.f121742a + "|" + hashCode() + ")";
    }

    public final p b(k kVar, String str, i0 i0Var) {
        p[] pVarArr;
        if (kVar != null && (pVarArr = kVar.f121702d) != null && pVarArr.length != 0) {
            for (p pVar : pVarArr) {
                if (pVar == null) {
                    x0.d(a(), "invalid version");
                } else {
                    x0.d(a(), "try match version:" + pVar.f121645a + ", filter:" + pVar.f121647c);
                    if (!v0.f() && pVar.f121662r) {
                        x0.d(a(), "forbid download when no uin and currently has no uin");
                    } else if (pVar.f121645a < 2000) {
                        x0.d(a(), "version is not support, below SDK_SUPPORT_MIN_APKVERSION");
                    } else {
                        int installedNewstVersion = XWalkEnvironment.getInstalledNewstVersion(pVar.f121647c.C);
                        if (pVar.f121645a <= installedNewstVersion) {
                            x0.d(a(), "version is too old, current version:" + installedNewstVersion);
                        } else {
                            pVar.f121647c.b(str);
                            if (!pVar.f121647c.a(false, true, i0Var.f121664a)) {
                                x0.d(a(), "version filter out");
                            } else {
                                String str2 = pVar.f121647c.C;
                                com.tencent.luggage.wxa.zq.b.a(str2);
                                if (!"arm64-v8a".equalsIgnoreCase(str2)) {
                                    "armeabi-v7a".equalsIgnoreCase(str2);
                                }
                                if (pVar.f121647c.l() && !pVar.f121763u) {
                                    x0.d(a(), "version.supportPredown is false, version:" + pVar.f121645a);
                                } else {
                                    return pVar;
                                }
                            }
                        }
                    }
                }
            }
            x0.d(a(), "getMatchedVersion, no matched version");
            return null;
        }
        x0.d(a(), "invalid config");
        return null;
    }

    public j0 a(k kVar, String str, i0 i0Var) {
        this.f121742a = i0Var.f121664a;
        j0 j0Var = new j0();
        p b16 = b(kVar, str, i0Var);
        if (b16 == null) {
            return null;
        }
        x0.d(a(), "getMatchedSchedulerConfig, got matched version:" + b16.f121645a);
        j0Var.f121677e = kVar.f121701c;
        j0Var.f121676d = b16.f121655k;
        j0Var.f121698z = b16.f121659o;
        j0Var.A = b16.f121660p;
        j0Var.B = b16.f121661q;
        j0Var.f121684l = b16.f121645a;
        j0Var.f121686n = b16.f121761s.f121766a;
        j0Var.f121689q = b16.f121656l;
        j0Var.f121690r = b16.f121657m;
        j0Var.f121691s = b16.f121762t;
        m a16 = a(b16, str);
        String str2 = b16.f121648d;
        j0Var.f121682j = str2;
        j0Var.f121692t = b16.f121647c.C;
        j0Var.f121693u = b16.f121646b;
        j0Var.f121694v = b16.f121649e;
        j0Var.f121695w = b16.f121650f;
        if (a16 != null) {
            j0Var.f121678f = true;
            j0Var.f121679g = a16.f121736a;
            j0Var.f121680h = a16.f121737b;
            j0Var.f121685m = a16.f121738c;
            j0Var.f121689q = a16.f121739d;
            j0Var.f121690r = a16.f121740e;
            j0Var.C = a16.f121741f;
        } else {
            j0Var.f121678f = false;
            j0Var.f121680h = str2;
        }
        j0Var.f121683k = i0.getUpdateTimeFromVersion(b16, i0Var.f121664a);
        return j0Var;
    }

    public final m a(p pVar, String str) {
        ArrayList arrayList = new ArrayList();
        m[] mVarArr = pVar.f121653i;
        int i3 = 0;
        if (mVarArr != null) {
            for (m mVar : mVarArr) {
                if (mVar.f121736a == XWalkEnvironment.getInstalledNewstVersion(str)) {
                    x0.d(a(), "getMatchedPatch, got candidate matched patch to upgrade to version:" + mVar.f121736a + ", its nPatchType is :" + mVar.f121741f);
                    arrayList.add(mVar);
                }
            }
        }
        if (!arrayList.isEmpty()) {
            int i16 = ((m) arrayList.get(0)).f121741f;
            for (int i17 = 1; i17 < arrayList.size(); i17++) {
                if (((m) arrayList.get(i17)).f121741f > i16) {
                    i16 = ((m) arrayList.get(i17)).f121741f;
                    i3 = i17;
                }
            }
            x0.d(a(), "getMatchedPatch, got final matched patch to upgrade to version:" + ((m) arrayList.get(i3)).f121736a + ", its nPatchType is :" + ((m) arrayList.get(i3)).f121741f);
            return (m) arrayList.get(i3);
        }
        x0.d(a(), "getMatchedPatch, no matched patch");
        return null;
    }
}
