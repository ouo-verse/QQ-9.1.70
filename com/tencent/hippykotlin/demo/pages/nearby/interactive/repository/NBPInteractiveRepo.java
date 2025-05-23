package com.tencent.hippykotlin.demo.pages.nearby.interactive.repository;

import c45.a;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.AdelieCategoryHomePage$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyApi$sendPbRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.kuikly.core.log.KLog;
import j35.b;
import j35.c;
import j35.d;
import j35.i;
import j35.k;
import k35.g;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.text.StringsKt__StringsJVMKt;
import org.apache.httpcore.message.TokenParser;

/* loaded from: classes31.dex */
public final class NBPInteractiveRepo implements IStrangerArkRepo {
    public static final NBPInteractiveRepo INSTANCE = new NBPInteractiveRepo();

    public static void fetchInteractUserList$default(int i3, a aVar, final Function1 function1) {
        GetInteractUserList getInteractUserList = new GetInteractUserList(i3, 20, aVar);
        Function1<PbResponse<g>, Unit> function12 = new Function1<PbResponse<g>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$fetchInteractUserList$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<g> pbResponse) {
                PbResponse<g> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchInteractUserList code:");
                m3.append(pbResponse2.code);
                m3.append(", msg:");
                AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m3, pbResponse2.f114187msg, kLog, "NBPInteractiveRepo");
                if (pbResponse2.success) {
                    function1.invoke(pbResponse2.rsp);
                } else {
                    function1.invoke(null);
                }
                return Unit.INSTANCE;
            }
        };
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.mood_svr.MoodSvr.SsoGetInteractUserList");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        QQKuiklyPlatformApi.Companion.sendPbRequest$default(getInteractUserList, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function12), 6);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.IStrangerArkRepo
    public final <T> void getArkMsg(T t16, final Function3<? super Integer, ? super String, ? super String, Unit> function3) {
        if (t16 instanceof c) {
            KLog kLog = KLog.INSTANCE;
            StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getArkMsg msgType=");
            c cVar = (c) t16;
            m3.append(cVar.f409208e);
            m3.append(" feed_id=");
            b bVar = cVar.f409209f;
            m3.append(bVar != null ? bVar.f409205d : null);
            m3.append(" tiny_id=");
            k kVar = cVar.f409210h;
            m3.append(kVar != null ? Long.valueOf(kVar.f409228d) : null);
            m3.append(" mood_id=");
            i iVar = cVar.f409211i;
            m3.append(iVar != null ? Integer.valueOf(iVar.f409225d) : null);
            m3.append(" attendance_share_info=");
            m3.append(cVar.f409212m);
            m3.append(TokenParser.SP);
            kLog.i("NBPInteractiveRepo", m3.toString());
            GetArkSignRequest getArkSignRequest = new GetArkSignRequest(cVar);
            Function1<PbResponse<d>, Unit> function1 = new Function1<PbResponse<d>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.interactive.repository.NBPInteractiveRepo$getArkMsg$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(PbResponse<d> pbResponse) {
                    a aVar;
                    byte[] bArr;
                    PbResponse<d> pbResponse2 = pbResponse;
                    KLog kLog2 = KLog.INSTANCE;
                    StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("getArkMsg result: ");
                    m16.append(pbResponse2.code);
                    m16.append(", ");
                    AdelieCategoryHomePage$$ExternalSyntheticOutline1.m(m16, pbResponse2.f114187msg, kLog2, "NBPInteractiveRepo");
                    d dVar = pbResponse2.rsp;
                    String decodeToString = (dVar == null || (aVar = dVar.f409213d) == null || (bArr = aVar.f30291a) == null) ? null : StringsKt__StringsJVMKt.decodeToString(bArr);
                    if (!pbResponse2.success) {
                        function3.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg, "");
                    } else if (decodeToString != null) {
                        function3.invoke(Integer.valueOf(pbResponse2.code), pbResponse2.f114187msg, decodeToString);
                    } else {
                        function3.invoke(-1, pbResponse2.f114187msg, "");
                    }
                    return Unit.INSTANCE;
                }
            };
            APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.lplan.interact_svr.Interact.SsoGetArkSign");
            QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
            QQKuiklyPlatformApi.Companion.sendPbRequest$default(getArkSignRequest, null, new NearbyApi$sendPbRequest$1(aPICallTechReporter, function1), 6);
            return;
        }
        KLog.INSTANCE.e("NBPInteractiveRepo", "getArkMsg params is not GetArkSignReq");
        function3.invoke(-1, "params is not GetArkSignReq", "");
    }
}
