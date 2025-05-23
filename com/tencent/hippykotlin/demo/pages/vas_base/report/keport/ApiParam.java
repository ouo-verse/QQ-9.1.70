package com.tencent.hippykotlin.demo.pages.vas_base.report.keport;

import b01.b;
import com.tencent.ams.dsdk.core.DKEngine;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.QQAudioParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.view.superResolution.LoadFailParams$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.extension.PageDataExtKt;
import com.tencent.hippykotlin.demo.pages.vas_base.report.Utils;
import com.tencent.hippykotlin.demo.pages.vas_base.report.vip_tracker.model.TraceHelper;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.nvi.serialization.json.e;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* loaded from: classes33.dex */
public final class ApiParam implements b {
    public static final Companion Companion = new Companion();
    public static final Lazy<String> platform$delegate;
    public final String apiCode;
    public String business;
    public final int duration;
    public final String networkCode;
    public final String networkType = Utils.INSTANCE.network();
    public final String url;

    /* loaded from: classes33.dex */
    public static final class Companion {
    }

    static {
        Lazy<String> lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<String>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.ApiParam$Companion$platform$2
            @Override // kotlin.jvm.functions.Function0
            public final String invoke() {
                return Utils.INSTANCE.platform();
            }
        });
        platform$delegate = lazy;
    }

    public ApiParam(String str, int i3, String str2, String str3, String str4) {
        this.url = str;
        this.duration = i3;
        this.networkCode = str2;
        this.apiCode = str3;
        this.business = str4;
    }

    public final int hashCode() {
        return this.business.hashCode() + BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.apiCode, BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline0.m(this.networkCode, QQAudioParams$$ExternalSyntheticOutline0.m(this.duration, this.url.hashCode() * 31, 31), 31), 31);
    }

    @Override // b01.b
    public final e serialization() {
        return new e(new Function1<e, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.vas_base.report.keport.ApiParam$serialization$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(e eVar) {
                e eVar2 = eVar;
                eVar2.z("url", ApiParam.this.url);
                eVar2.z("duration", Integer.valueOf(ApiParam.this.duration));
                eVar2.z("networkCode", ApiParam.this.networkCode);
                eVar2.z("apiCode", ApiParam.this.apiCode);
                eVar2.z("platform", ApiParam.platform$delegate.getValue());
                eVar2.z(DKEngine.GlobalKey.NET_WORK_TYPE, ApiParam.this.networkType);
                c cVar = c.f117352a;
                eVar2.z("appVersion", cVar.g().getPageData().getAppVersion());
                eVar2.z("resVersion", Long.valueOf(PageDataExtKt.getResVersion(cVar.g().getPageData())));
                eVar2.z("business", ApiParam.this.business);
                eVar2.z("page", cVar.g().getPageName());
                eVar2.z("from", TraceHelper.INSTANCE.getEnteranceId());
                return Unit.INSTANCE;
            }
        });
    }

    public final String toString() {
        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("ApiParam(url=");
        m3.append(this.url);
        m3.append(", duration=");
        m3.append(this.duration);
        m3.append(", networkCode=");
        m3.append(this.networkCode);
        m3.append(", apiCode=");
        m3.append(this.apiCode);
        m3.append(", business=");
        return LoadFailParams$$ExternalSyntheticOutline0.m(m3, this.business, ')');
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ApiParam)) {
            return false;
        }
        ApiParam apiParam = (ApiParam) obj;
        return Intrinsics.areEqual(this.url, apiParam.url) && this.duration == apiParam.duration && Intrinsics.areEqual(this.networkCode, apiParam.networkCode) && Intrinsics.areEqual(this.apiCode, apiParam.apiCode) && Intrinsics.areEqual(this.business, apiParam.business);
    }
}
