package com.tencent.luggage.wxa.yq;

import android.text.TextUtils;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.m0;
import com.tencent.luggage.wxa.ar.n0;
import com.tencent.luggage.wxa.ar.q0;
import com.tencent.luggage.wxa.ar.s0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class l extends m {

    /* renamed from: g, reason: collision with root package name */
    public static l f146086g;

    public static m g() {
        if (f146086g == null) {
            f146086g = new l();
        }
        return f146086g;
    }

    @Override // com.tencent.luggage.wxa.yq.m
    public j0 a(com.tencent.luggage.wxa.ar.k kVar) {
        j0 j0Var = null;
        if (kVar == null) {
            return null;
        }
        boolean z16 = false;
        if (!CommandCfg.getInstance().getCmdAsBoolean("enable_predown_core", "tools", false)) {
            x0.a(this.f121664a, "onConfigDownLoaded, config version:" + kVar.f121701c + ", disable predown core");
            abandonCurrentScheduler();
            if (q0.a(XWalkEnvironment.getInstalledNewstVersionForPredownAbi())) {
                n0.a(1749L, 85);
            }
            if ("armeabi-v7a".equalsIgnoreCase(com.tencent.luggage.wxa.ar.b.b())) {
                if (s0.a("arm64-v8a").f121780a != -1) {
                    XWalkEnvironment.setCoreVersionInfo(-1, null, "arm64-v8a");
                }
            } else if (s0.a("armeabi-v7a").f121780a != -1) {
                XWalkEnvironment.setCoreVersionInfo(-1, null, "armeabi-v7a");
            }
            return null;
        }
        String cmd = CommandCfg.getInstance().getCmd("pre_down_abi", "tools");
        x0.a(this.f121664a, "onConfigDownLoaded, config version:" + kVar.f121701c + ", enable predown core:" + cmd);
        if (!TextUtils.isEmpty(cmd) && !cmd.equalsIgnoreCase(com.tencent.luggage.wxa.ar.b.b()) && (j0Var = new m0().a(kVar, cmd, this)) != null) {
            n0.a(577L, 240L, 1L);
        }
        if (j0Var != null) {
            x0.a(this.f121664a, "onConfigDownLoaded, pre download version:" + j0Var.f121684l);
            z16 = true;
        }
        j0 onUpdateScheduleConfig = onUpdateScheduleConfig(j0Var);
        if (z16 && onUpdateScheduleConfig == j0Var) {
            if ("armeabi-v7a".equalsIgnoreCase(j0Var.f121692t)) {
                n0.a(577L, 236L, 1L);
            } else if ("arm64-v8a".equalsIgnoreCase(j0Var.f121692t)) {
                n0.a(577L, 237L, 1L);
            }
        }
        return onUpdateScheduleConfig;
    }

    @Override // com.tencent.luggage.wxa.yq.m, com.tencent.luggage.wxa.ar.i0
    public boolean e() {
        return false;
    }

    @Override // com.tencent.luggage.wxa.yq.m, com.tencent.luggage.wxa.ar.i0
    public String getScheduleType() {
        return "XWebCorePredown";
    }
}
