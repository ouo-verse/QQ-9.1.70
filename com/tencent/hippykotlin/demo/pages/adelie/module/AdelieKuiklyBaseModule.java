package com.tencent.hippykotlin.demo.pages.adelie.module;

import com.tencent.ad.tangram.analysis.sqlite.AdAnalysisSQLiteColumns;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.shortvideo.videotransfer.TransferConfig;
import cooperation.qzone.remote.logic.RemoteHandleConst;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieKuiklyBaseModule extends Module {
    public static final /* synthetic */ int $r8$clinit = 0;

    public final void getQQMCConfig(String str, String str2, Function1<? super e, Unit> function1) {
        e eVar = new e();
        eVar.v("key", str);
        eVar.v(RemoteHandleConst.PARAM_DEFAULT_VALUE, str2);
        toNative(false, "getQQMCConfig", eVar.toString(), function1, false);
    }

    public final String getQQMCConfigSync(String str) {
        e eVar = new e();
        eVar.v("key", str);
        eVar.v(RemoteHandleConst.PARAM_DEFAULT_VALUE, "");
        Object returnValue = toNative(false, "getQQMCConfigSync", eVar.toString(), null, true).getReturnValue();
        Intrinsics.checkNotNull(returnValue, "null cannot be cast to non-null type kotlin.String");
        return (String) returnValue;
    }

    public final String getStringFromCache$enumunboxing$(String str, String str2, int i3, int i16) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("key", str, RemoteHandleConst.PARAM_DEFAULT_VALUE, str2);
        if (i3 != 0) {
            m3.t(TransferConfig.ExtendParamFloats.KEY_RULE, i3 - 1);
            if (i16 != 0) {
                m3.t(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, i16 - 1);
                Object returnValue = toNative(false, "getStringFromCache", m3.toString(), null, true).getReturnValue();
                Intrinsics.checkNotNull(returnValue, "null cannot be cast to non-null type kotlin.String");
                return (String) returnValue;
            }
            throw null;
        }
        throw null;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "AdelieKuiklyBaseModule";
    }

    public final void reportBeacon(String str, e eVar) {
        e eVar2 = new e();
        eVar2.v("event_name", str);
        eVar2.v("report_param", eVar);
        toNative(false, "reportBeacon", eVar2.toString(), null, false);
    }

    public final void setStringToCache$enumunboxing$(String str, String str2, int i3, int i16) {
        e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("key", str, "value", str2);
        if (i3 != 0) {
            m3.t(TransferConfig.ExtendParamFloats.KEY_RULE, i3 - 1);
            if (i16 != 0) {
                m3.t(AdAnalysisSQLiteColumns.COLUMN_NAME_STRATEGY, i16 - 1);
                toNative(false, "setStringToCache", m3.toString(), null, true);
                return;
            }
            throw null;
        }
        throw null;
    }

    public final boolean getBooleanFromCache(String str) {
        return Boolean.parseBoolean(getStringFromCache$enumunboxing$(str, "", 1, 2));
    }

    public static /* synthetic */ String getStringFromCache$default(AdelieKuiklyBaseModule adelieKuiklyBaseModule, String str, String str2, int i3) {
        if ((i3 & 2) != 0) {
            str2 = "";
        }
        return adelieKuiklyBaseModule.getStringFromCache$enumunboxing$(str, str2, (i3 & 4) != 0 ? 1 : 0, (i3 & 8) == 0 ? 0 : 1);
    }
}
