package com.tencent.hippykotlin.demo.pages.nearby.base.repo;

import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import n25.i;
import n25.k;
import n25.m;
import n35.w;
import s25.f;

/* loaded from: classes31.dex */
public final class NBPPublishRepository {
    public static final NBPPublishRepository INSTANCE = new NBPPublishRepository();

    public final void requestPublishFeed(int i3, int i16, int i17, String str, k kVar, List<w> list, List<m> list2, List<String> list3, int i18, final Function1<? super f, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8 = "";
        String str9 = (kVar == null || (str7 = kVar.f418086d) == null) ? "" : str7;
        i iVar = kVar != null ? kVar.C : null;
        String safeStringForRequest = safeStringForRequest(kVar != null ? kVar.f418090i : null, "");
        String safeStringForRequest2 = safeStringForRequest(kVar != null ? kVar.G : null, "\u6d77\u5916");
        String str10 = kVar != null ? kVar.H : null;
        if (kVar == null || (str2 = kVar.G) == null) {
            str2 = "";
        }
        String safeStringForRequest3 = safeStringForRequest(str10, str2);
        String str11 = kVar != null ? kVar.I : null;
        if (kVar == null || (str3 = kVar.H) == null) {
            str3 = "";
        }
        String safeStringForRequest4 = safeStringForRequest(str11, str3);
        if (kVar == null || (str4 = kVar.M) == null) {
            str4 = "Unknown";
        }
        String str12 = str4;
        String str13 = kVar != null ? kVar.f418087e : null;
        if (kVar == null || (str5 = kVar.I) == null) {
            str5 = "";
        }
        String safeStringForRequest5 = safeStringForRequest(str13, str5);
        String str14 = kVar != null ? kVar.Q : null;
        if (kVar != null && (str6 = kVar.I) != null) {
            str8 = str6;
        }
        GetPostStatusRequest getPostStatusRequest = new GetPostStatusRequest(i3, i16, i17, str, new k(str9, safeStringForRequest5, 0, (String) null, safeStringForRequest, 0, iVar, 0, 0, (String) null, safeStringForRequest2, safeStringForRequest3, safeStringForRequest4, 0, 0, (String) null, str12, (String) null, (String) null, safeStringForRequest(str14, str8), 1500076), list, list2, list3, i18);
        Function1<PbResponse<f>, Unit> function12 = new Function1<PbResponse<f>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.base.repo.NBPPublishRepository$requestPublishFeed$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<f> pbResponse) {
                PbResponse<f> pbResponse2 = pbResponse;
                if (pbResponse2.success) {
                    function1.invoke(pbResponse2.rsp);
                } else {
                    function2.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg);
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.feed_svr.StatusWrite.SsoPostStatus");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getPostStatusRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }

    public final String safeStringForRequest(String str, String str2) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return str;
            }
        }
        return str2.length() == 0 ? "Unknown" : str2;
    }
}
