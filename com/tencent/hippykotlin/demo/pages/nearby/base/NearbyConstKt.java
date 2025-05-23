package com.tencent.hippykotlin.demo.pages.nearby.base;

import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager;
import com.tencent.hippykotlin.demo.pages.nearby.main.base.NBPViewModelStoreKt;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import com.tencent.kuikly.core.pager.b;
import com.tencent.qqlive.module.videoreport.dtreport.constants.DTParamKey;
import defpackage.k;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class NearbyConstKt {
    public static final e getNearbyDTBaseParams() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m(DTParamKey.REPORT_KEY_APPKEY, "0AND05J90ZOPH3DU");
    }

    public static final e jsonWithMainPgParams() {
        c cVar = c.f117352a;
        b g16 = cVar.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager");
        final NBPMainPager nBPMainPager = (NBPMainPager) g16;
        nBPMainPager.getClass();
        e eVar = new e();
        if (k.a(cVar)) {
            eVar.v("cur_pg", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$pageReportParams$1$1
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3 = eVar2;
                    eVar3.t("nearby_user_from", NBPMainPager.this.source);
                    eVar3.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).getThemeMapType());
                    eVar3.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).reportThemeMapId);
                    eVar3.v("nearby_tiny_id", String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
                    return Unit.INSTANCE;
                }
            }));
        } else {
            eVar.v("cur_pg", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$pageReportParams$1$2
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(e eVar2) {
                    e eVar3 = eVar2;
                    eVar3.t("nearby_user_from", NBPMainPager.this.source);
                    eVar3.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).getThemeMapType());
                    eVar3.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).reportThemeMapId);
                    eVar3.v("nearby_tiny_id", String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
                    return Unit.INSTANCE;
                }
            }));
            eVar.t("nearby_user_from", nBPMainPager.source);
            eVar.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(nBPMainPager.getVmStore()).getThemeMapType());
            eVar.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(nBPMainPager.getVmStore()).reportThemeMapId);
            eVar.v("nearby_tiny_id", String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
        }
        eVar.v("dt_pgid", "pg_nearby_home_map");
        return eVar;
    }

    public static final e jsonWithMainPgParamsImp() {
        b g16 = c.f117352a.g();
        Intrinsics.checkNotNull(g16, "null cannot be cast to non-null type com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager");
        final NBPMainPager nBPMainPager = (NBPMainPager) g16;
        nBPMainPager.getClass();
        e eVar = new e();
        eVar.v("cur_pg", new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.main.NBPMainPager$pageReportParamsImp$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar2) {
                e eVar3 = eVar2;
                eVar3.t("nearby_user_from", NBPMainPager.this.source);
                eVar3.t("nearby_map_type", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).getThemeMapType());
                eVar3.v("nearby_map_id", NBPViewModelStoreKt.getMapThemeVM(NBPMainPager.this.getVmStore()).reportThemeMapId);
                eVar3.v("nearby_tiny_id", String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid));
                return Unit.INSTANCE;
            }
        }));
        eVar.v("dt_pgid", "pg_nearby_home_map");
        return eVar;
    }

    public static final e jsonWithPublishPgParams() {
        return AdelieCategoryHomePage$$ExternalSyntheticOutline0.m("dt_pgid", "pg_nearby_dynamic_publish");
    }
}
