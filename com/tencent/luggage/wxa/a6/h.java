package com.tencent.luggage.wxa.a6;

import com.tencent.luggage.wxa.ei.t;
import com.tencent.luggage.wxa.mc.q0;
import com.tencent.luggage.wxa.tn.w;
import com.tencent.mm.plugin.appbrand.appcache.ModulePkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPluginPkgInfo;
import java.util.Arrays;
import java.util.List;

/* compiled from: P */
/* loaded from: classes8.dex */
public class h extends com.tencent.luggage.wxa.w1.e {
    public h(com.tencent.luggage.wxa.r4.d dVar, t tVar) {
        super(dVar, tVar);
    }

    @Override // com.tencent.luggage.wxa.r4.b
    public int a(com.tencent.luggage.wxa.ei.h hVar, String str) {
        w.d("Luggaeg.WAGameJsContextInterfaceStandalone", "hy: injectWxaScript from js context interface: %s %d", str, Integer.valueOf(hVar.q()));
        w.d("Luggaeg.WAGameJsContextInterfaceStandalone", "injectGameContextPlugin :%b, abtest:%b", Boolean.valueOf(Boolean.parseBoolean(this.f139096a.i().h("injectGameContextPlugin"))), Boolean.FALSE);
        a(str, hVar);
        return super.a(hVar, str);
    }

    public final int a(String str, com.tencent.luggage.wxa.ei.h hVar) {
        List<WxaPluginPkgInfo> list;
        w.d("Luggaeg.WAGameJsContextInterfaceStandalone", "injectPluginCodeNewLogic");
        if (str.equals("game.js")) {
            q0 q0Var = this.f139096a.getRuntime().j0().f125966l.f151866f;
            if (q0Var != null) {
                list = q0Var.b(ModulePkgInfo.MAIN_MODULE_NAME);
            } else {
                w.b("Luggaeg.WAGameJsContextInterfaceStandalone", "pluginCodeList wxaRuntimeModulePluginListMap null");
                list = null;
            }
            if (list != null && list.size() > 0) {
                w.d("Luggaeg.WAGameJsContextInterfaceStandalone", "client inject pluginCode size:%s", Integer.valueOf(list.size()));
                for (WxaPluginPkgInfo wxaPluginPkgInfo : list) {
                    List<Integer> list2 = wxaPluginPkgInfo.contexts;
                    if (list2 != null) {
                        w.a("Luggaeg.WAGameJsContextInterfaceStandalone", "multiPkg contexts size:%d,contexts:%s", Integer.valueOf(list2.size()), Arrays.toString(list2.toArray()));
                    }
                    if (list2 != null && list2.contains(0)) {
                        String str2 = wxaPluginPkgInfo.prefixPath + ModulePkgInfo.GAME_PLUGIN_SCRIPT;
                        w.a("Luggaeg.WAGameJsContextInterfaceStandalone", "pluginCodefilePath:%s", str2);
                        super.a(hVar, str2);
                    }
                }
            }
        }
        return 1;
    }
}
