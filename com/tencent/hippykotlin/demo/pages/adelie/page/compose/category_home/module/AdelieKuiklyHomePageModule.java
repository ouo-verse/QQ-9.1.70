package com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module;

import c45.a;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule$$ExternalSyntheticOutline0;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.Module;
import com.tencent.kuikly.core.nvi.serialization.json.b;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.mobileqq.app.AppConstants;
import f25.h;
import f25.i;
import f25.j;
import g25.g;
import g25.k;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes31.dex */
public final class AdelieKuiklyHomePageModule extends Module {
    public final e createRobotInfoJson(k kVar) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        List<h> list;
        List<j> list2;
        String str6;
        e eVar = new e();
        eVar.v("uid", kVar.G);
        eVar.u("uin", kVar.f401171d);
        eVar.v("nick", kVar.f401173e);
        f25.e eVar2 = kVar.N;
        String str7 = "";
        if (eVar2 == null || (str = eVar2.f397738d) == null) {
            str = "";
        }
        eVar.v("dayUrl", str);
        f25.e eVar3 = kVar.N;
        if (eVar3 == null || (str2 = eVar3.f397739e) == null) {
            str2 = "";
        }
        eVar.v("nightUrl", str2);
        eVar.t("bizType", kVar.K);
        f25.e eVar4 = kVar.N;
        if (eVar4 == null || (str3 = eVar4.f397742i) == null) {
            str3 = "";
        }
        eVar.v("dayColor", str3);
        f25.e eVar5 = kVar.N;
        if (eVar5 == null || (str4 = eVar5.f397743m) == null) {
            str4 = "";
        }
        eVar.v("nightColor", str4);
        eVar.v("avatarDominantColor", kVar.Y);
        f25.e eVar6 = kVar.N;
        if (eVar6 == null || (str5 = eVar6.f397740f) == null) {
            str5 = "";
        }
        eVar.v("dayDynamicPic", str5);
        f25.e eVar7 = kVar.N;
        if (eVar7 != null && (str6 = eVar7.f397741h) != null) {
            str7 = str6;
        }
        eVar.v("nightDynamicPic", str7);
        i iVar = kVar.Z;
        eVar.w("isSupportTts", (iVar == null || (list2 = iVar.f397754e) == null) ? false : !list2.isEmpty());
        g25.e eVar8 = kVar.Q;
        if (eVar8 != null && (list = eVar8.f401154f) != null) {
            for (h hVar : list) {
                Integer num = hVar.f397750d;
                if (num != null && num.intValue() == 14) {
                    a aVar = hVar.f397751e;
                    if ((aVar != null ? aVar.f30291a : null) != null) {
                        f25.a aVar2 = new f25.a(null, null, 3, null);
                        a aVar3 = hVar.f397751e;
                        Intrinsics.checkNotNull(aVar3);
                        f25.a aVar4 = (f25.a) c45.i.b(aVar2, aVar3.f30291a);
                        eVar.v("supportHalfScreenSwitch", aVar4.f397726d);
                        eVar.v("isSupportAutoTts", aVar4.f397727e);
                    }
                }
            }
        }
        if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(c.f117352a)) {
            try {
                i iVar2 = kVar.Z;
                eVar.v("robotTTSListJSONObject", iVar2 != null ? toJSONObject(iVar2) : null);
            } catch (Throwable th5) {
                AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("putTtsListFailed, t", th5, KLog.INSTANCE, "AdelieKuiklyHomePageModule");
            }
        }
        return eVar;
    }

    @Override // com.tencent.kuikly.core.module.Module
    public final String moduleName() {
        return "AdelieKuiklyHomePageModule";
    }

    public final void preloadAIOGuideInfo$qecommerce_biz_release(g gVar, Function1<? super e, Unit> function1) {
        e eVar = new e();
        eVar.v("bgUrl", gVar.f401158e);
        eVar.v(AppConstants.Key.KEY_QZONE_VIDEO_URL, gVar.f401161i);
        k kVar = gVar.f401162m;
        if (kVar != null) {
            e createRobotInfoJson = createRobotInfoJson(kVar);
            Iterator<String> c16 = createRobotInfoJson.c();
            while (c16.hasNext()) {
                String next = c16.next();
                eVar.v(next, createRobotInfoJson.e(next));
            }
        }
        toNative(false, "preloadAIOGuideInfo", eVar.toString(), function1, false);
    }

    public final e toJSONObject(i iVar) {
        e eVar = new e();
        Object obj = iVar.f397753d;
        List<j> list = iVar.f397754e;
        b bVar = new b();
        for (j jVar : list) {
            String str = jVar.f397755d;
            String str2 = jVar.f397756e;
            String str3 = jVar.f397757f;
            String str4 = jVar.f397758h;
            e m3 = AdelieKuiklyBaseModule$$ExternalSyntheticOutline0.m("ttsId", str, "ttsName", str2);
            m3.v("ttsIcon", str3);
            m3.v("ttsExample", str4);
            bVar.t(m3);
        }
        eVar.v("defaultTtsId", obj);
        eVar.v("ttsList", bVar);
        return eVar;
    }
}
