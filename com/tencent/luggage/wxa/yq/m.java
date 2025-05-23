package com.tencent.luggage.wxa.yq;

import com.tencent.luggage.wxa.ar.i0;
import com.tencent.luggage.wxa.ar.j0;
import com.tencent.luggage.wxa.ar.m0;
import com.tencent.luggage.wxa.ar.x0;
import com.tencent.xweb.CommandCfg;
import com.tencent.xweb.WebDebugCfg;
import com.tencent.xweb.XWebEmbedSetting;
import org.xwalk.core.XWalkEnvironment;

/* compiled from: P */
/* loaded from: classes9.dex */
public class m extends i0 {

    /* renamed from: e, reason: collision with root package name */
    public static m f146087e = null;

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ boolean f146088f = true;

    public static m f() {
        if (f146087e == null) {
            f146087e = new m();
        }
        return f146087e;
    }

    @Override // com.tencent.luggage.wxa.ar.i0
    public String a(boolean z16) {
        if (!z16) {
            return CommandCfg.getInstance().getCmd("UPDATE_SPEED_CONFIG", "tools");
        }
        return CommandCfg.getInstance().getCmd("UPDATE_FORWARD_SPEED_CONFIG", "tools");
    }

    @Override // com.tencent.luggage.wxa.ar.i0
    public boolean e() {
        if (!XWalkEnvironment.hasInstalledAvailableVersion()) {
            if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("dis_update_immediately_when_no_xweb", "tools"))) {
                if (getCurSchedulerConfig().f121687o > 0) {
                    x0.a(this.f121664a, "needForceUpdate, update failed before, do not force update");
                    if (!"true".equalsIgnoreCase(CommandCfg.getInstance().getCmd("allow_failed_schedule_force_update", "tools"))) {
                        return false;
                    }
                }
                x0.a(this.f121664a, "needForceUpdate, no availableVersion installed, do start download");
                return true;
            }
            x0.a(this.f121664a, "needForceUpdate, no availableVersion but dis_update_immediately_when_no_xweb is true");
        }
        return false;
    }

    @Override // com.tencent.luggage.wxa.ar.i0
    public String getScheduleType() {
        return "XWebCore";
    }

    @Override // com.tencent.luggage.wxa.ar.i0
    public synchronized boolean hasScheduler() {
        if (!super.hasScheduler()) {
            return false;
        }
        if (getCurSchedulerConfig().f121684l <= XWalkEnvironment.getInstalledNewstVersion(getCurSchedulerConfig().f121692t)) {
            x0.f(this.f121664a, "hasScheduler, scheduler config version lower than current version");
            return false;
        }
        return true;
    }

    public j0 a(com.tencent.luggage.wxa.ar.k kVar) {
        if (kVar == null) {
            return null;
        }
        x0.a(this.f121664a, "onConfigDownLoaded, config version:" + kVar.f121701c + ", runtime abi:" + com.tencent.luggage.wxa.ar.b.b());
        if (XWebEmbedSetting.getForbidDownloadCode() && !XWalkEnvironment.isInTestMode()) {
            x0.a(this.f121664a, "onConfigDownLoaded, forbid download code");
            return null;
        }
        j0 onUpdateScheduleConfig = onUpdateScheduleConfig(new m0().a(kVar, com.tencent.luggage.wxa.ar.b.b(), this));
        if (onUpdateScheduleConfig != null) {
            x0.a(this.f121664a, "onConfigDownLoaded, download apk version:" + onUpdateScheduleConfig.f121684l);
        }
        return onUpdateScheduleConfig;
    }

    public f a(j0 j0Var) {
        f fVar;
        String str;
        try {
            if (!j0Var.f121678f) {
                String str2 = j0Var.f121676d;
                if (str2 != null && !str2.isEmpty()) {
                    fVar = new f(j0Var.f121676d, false, null, j0Var.f121680h, j0Var.f121684l, j0Var.f121692t, j0Var.f121679g, j0Var.C);
                    if (WebDebugCfg.getInst().getEnableDebugPackage()) {
                        fVar.f146072g = "http://dldir1.qq.com/weixin/android/wxwebtest/datafile/config/packagefile/runtime_package.zip";
                        fVar.f146067b = false;
                    }
                }
                if (f146088f) {
                    fVar = new f(j0Var.f121680h, false, j0Var.f121684l, j0Var.f121692t, j0Var.f121679g, j0Var.C);
                } else {
                    throw new AssertionError("royle:no md5 info, maybe something wrong");
                }
            } else {
                String str3 = j0Var.f121676d;
                if (str3 != null && !str3.isEmpty() && (str = j0Var.f121685m) != null && !str.isEmpty()) {
                    fVar = new f(j0Var.f121685m, true, j0Var.f121676d, j0Var.f121680h, j0Var.f121684l, j0Var.f121692t, j0Var.f121679g, j0Var.C);
                }
                if (f146088f) {
                    fVar = new f(j0Var.f121680h, true, j0Var.f121684l, j0Var.f121692t, j0Var.f121679g, j0Var.C);
                } else {
                    throw new AssertionError("royle:no md5 info, maybe something wrong");
                }
            }
            fVar.f146074i = j0Var.f121686n;
            fVar.f146075j = j0Var.f121690r;
            fVar.f146076k = j0Var.f121691s;
            fVar.f146066a = this;
            return fVar;
        } catch (Throwable th5) {
            x0.a(this.f121664a, "getUpdateConfig error", th5);
            return null;
        }
    }
}
