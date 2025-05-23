package com.tencent.rdelivery.reshub.util;

import com.tencent.rdelivery.reshub.local.LocalResConfigManager;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.apache.httpcore.message.TokenParser;
import org.jetbrains.annotations.NotNull;

/* compiled from: P */
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001a\"\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002\u001a$\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u001c\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0001\u001a\u00020\u00002\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002\u001a\u0012\u0010\f\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a,\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0001\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0002H\u0002\u001a\u0014\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004H\u0002\u001a$\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00042\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u0006H\u0002\u00a8\u0006\u0013"}, d2 = {"Ljz3/e;", "remoteConfig", "Lcom/tencent/rdelivery/reshub/core/k;", "req", "Lkotlin/Pair;", "", "", "b", "c", "extraMsg", "", "g", "d", "localConfig", "f", "e", "resId", "reason", "a", "reshub_debug"}, k = 2, mv = {1, 4, 0})
/* loaded from: classes25.dex */
public final class j {
    private static final Pair<Boolean, String> a(String str, String str2) {
        jz3.d.c("RemoteResConfig", "Bad Remote ResConfig(" + str + "): " + str2);
        return new Pair<>(Boolean.FALSE, str2);
    }

    @NotNull
    public static final Pair<Boolean, String> b(@NotNull jz3.e remoteConfig, @NotNull com.tencent.rdelivery.reshub.core.k req) {
        Intrinsics.checkParameterIsNotNull(remoteConfig, "remoteConfig");
        Intrinsics.checkParameterIsNotNull(req, "req");
        if (!remoteConfig.l()) {
            String str = "Invalid ResConfig(Check id/version/size/md5/url): " + remoteConfig + '.';
            String str2 = remoteConfig.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str2, "remoteConfig.id");
            return a(str2, str);
        }
        if (!Intrinsics.areEqual(remoteConfig.f411260a, req.x())) {
            String str3 = "Remote ResId(" + remoteConfig.f411260a + ") != Request ResId(" + req.x() + ").";
            String str4 = remoteConfig.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str4, "remoteConfig.id");
            return a(str4, str3);
        }
        int c16 = k.c(remoteConfig, req);
        if (remoteConfig.f411261b < c16) {
            String str5 = "Remote Version(" + remoteConfig.f411261b + ") < MinVersion(" + c16 + ").";
            String str6 = remoteConfig.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str6, "remoteConfig.id");
            return a(str6, str5);
        }
        if (!a.b(remoteConfig, com.tencent.rdelivery.reshub.core.j.L.e(req.getAppInfo()))) {
            String str7 = remoteConfig.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str7, "remoteConfig.id");
            return a(str7, "Current App Version > Remote ResAppMaxVer.");
        }
        return c(remoteConfig, req);
    }

    private static final Pair<Boolean, String> c(jz3.e eVar, com.tencent.rdelivery.reshub.core.k kVar) {
        h(eVar, null, 2, null);
        jz3.e d16 = d(kVar);
        if (d16 != null) {
            long j3 = eVar.f411261b;
            long j16 = d16.f411261b;
            if (j3 > j16) {
                return e();
            }
            boolean z16 = true;
            if (j3 == j16) {
                g(eVar, "Remote Version == Local Version, Local ResConfig Will Be Closed.");
                if (!(!Intrinsics.areEqual(eVar.f411264e, d16.f411264e)) && eVar.f411263d == d16.f411263d) {
                    z16 = false;
                }
                if (z16) {
                    return f(eVar, d16, kVar);
                }
                return e();
            }
            com.tencent.rdelivery.reshub.core.j jVar = com.tencent.rdelivery.reshub.core.j.L;
            if (!a.b(d16, jVar.e(kVar.getAppInfo()))) {
                if (kVar.getPresetResConfig() != null && eVar.f411261b < kVar.getPresetResConfig().f411261b && kVar.getMode() != 4) {
                    kVar.G(kVar.getPresetResConfig());
                    jz3.d.e("RemoteResConfig", "local res invalid\uff0cremote " + eVar.f411261b + TokenParser.SP + "lower than preset " + kVar.getPresetResConfig().f411261b + ",use presetResConfig");
                    return e();
                }
                jz3.d.e("RemoteResConfig", "local res invalid, use remote");
                return e();
            }
            if (d16.f411285z == 1) {
                if (kVar.getPresetResConfig() != null && eVar.f411261b < kVar.getPresetResConfig().f411261b && kVar.getMode() != 4) {
                    kVar.G(kVar.getPresetResConfig());
                    jz3.d.e("RemoteResConfig", "local res allowAssetDowngrade\uff0cremote " + eVar.f411261b + TokenParser.SP + "lower than preset " + kVar.getPresetResConfig().f411261b + ",use presetResConfig");
                    return e();
                }
                jz3.d.e("RemoteResConfig", "local res allowAssetDowngrade, use remote");
                return e();
            }
            if (jVar.J()) {
                String str = "Remote ResConfig(" + eVar.f411260a + ") Version(" + eVar.f411261b + ") < Local Version(" + d16.f411261b + ").";
                jz3.d.c("RemoteResConfig", str);
                String str2 = eVar.f411260a;
                Intrinsics.checkExpressionValueIsNotNull(str2, "remoteConfig.id");
                return a(str2, str);
            }
            kVar.G(d16);
            jz3.d.c("RemoteResConfig", "Remote ResConfig(" + eVar.f411260a + ") Not Usable: Remote Version(" + eVar.f411261b + ") < Local Version(" + d16.f411261b + "), Use Local ResConfig (Unstrict Mode).");
            return e();
        }
        return e();
    }

    private static final jz3.e d(com.tencent.rdelivery.reshub.core.k kVar) {
        LocalResConfigManager configMap = kVar.getConfigMap();
        if (kVar.getMode() == 4) {
            return configMap.p(kVar.x(), kVar.getCom.tencent.mobileqq.mini.servlet.MiniAppGetGameTaskTicketServlet.KEY_TASKID java.lang.String());
        }
        return configMap.m(kVar.x());
    }

    private static final Pair<Boolean, String> e() {
        return new Pair<>(Boolean.TRUE, "");
    }

    private static final Pair<Boolean, String> f(jz3.e eVar, jz3.e eVar2, com.tencent.rdelivery.reshub.core.k kVar) {
        String str = "Remote ResConfig(" + eVar.f411260a + ") ResFile Changed(MD5: " + eVar.f411264e + " Size: " + eVar.f411263d + ") For Same Version(" + eVar.f411261b + "), Not In Accordance With Saved Local ResConfig(MD5: " + eVar2.f411264e + " Size: " + eVar2.f411263d + ").";
        int i3 = i.f364603a[com.tencent.rdelivery.reshub.core.j.L.C().ordinal()];
        if (i3 != 1) {
            if (i3 != 2) {
                if (i3 == 3) {
                    kVar.G(eVar2);
                    jz3.d.i("RemoteResConfig", str + " Use Local ResConfig (Ignore Mode).");
                    return e();
                }
                throw new NoWhenBranchMatchedException();
            }
            LocalResConfigManager configMap = kVar.getConfigMap();
            String str2 = eVar.f411260a;
            Intrinsics.checkExpressionValueIsNotNull(str2, "remoteConfig.id");
            configMap.h(str2);
            jz3.d.i("RemoteResConfig", str + " Delete Local Res (Override Mode).");
            return e();
        }
        jz3.d.c("RemoteResConfig", str + " (Error Mode)");
        String str3 = eVar.f411260a;
        Intrinsics.checkExpressionValueIsNotNull(str3, "remoteConfig.id");
        return a(str3, str);
    }

    private static final void g(jz3.e eVar, String str) {
        if (eVar.f411278s == 1) {
            jz3.d.e("RemoteResConfig", "Remote ResConfig(" + eVar.f411260a + ") is Closed. Version(" + eVar.f411261b + TokenParser.SP + str + ") ");
        }
    }

    static /* synthetic */ void h(jz3.e eVar, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        g(eVar, str);
    }
}
