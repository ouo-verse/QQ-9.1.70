package com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository;

import c45.e;
import c45.i;
import com.epicgames.ue4.ZPlanVersion;
import com.qzone.album.data.model.PhotoCategorySummaryInfo;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.foundation.module.PbResponse;
import com.tencent.hippykotlin.demo.pages.foundation.module.QQKuiklyPlatformApi;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.article_feed_detail.NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyBasePbRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.NearbyConst;
import com.tencent.hippykotlin.demo.pages.nearby.base.data.UserDataManager;
import com.tencent.hippykotlin.demo.pages.nearby.base.module.QQNearbyModule;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoRequest;
import com.tencent.hippykotlin.demo.pages.nearby.base.repo.QQStrangerSsoService$sendProxyRequest$1;
import com.tencent.hippykotlin.demo.pages.nearby.base.tech_reporter.APICallTechReporter;
import com.tencent.hippykotlin.demo.pages.nearby.new_homepage.data.TagInfo;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.module.MemoryCacheModule;
import f35.c;
import f35.d;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.BooleanCompanionObject;
import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;
import kotlin.jvm.internal.StringCompanionObject;
import oicq.wlogin_sdk.tools.util;
import r25.b;
import s35.a;
import s35.aa;
import s35.af;
import s35.ag;
import s35.g;
import s35.r;

/* loaded from: classes31.dex */
public final class NBPNewHomeRepository {
    public static final NBPNewHomeRepository INSTANCE = new NBPNewHomeRepository();

    /* loaded from: classes31.dex */
    public static final class GetOpenIDRequest extends NearbyBasePbRequest<c, d> {
        public final long tid;

        public GetOpenIDRequest(long j3) {
            this.tid = j3;
        }

        @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
        public final e decodeResponse(byte[] bArr) {
            return (d) i.b(new d(null, null, false, 7, null), bArr);
        }

        @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
        public final String getCmd() {
            return "trpc.lplan.user_manager_svr.User.SsoGetOpenId";
        }

        @Override // com.tencent.hippykotlin.demo.pages.foundation.module.BasePbRequest
        public final e getRequest() {
            return new c(UserDataManager.INSTANCE.getCommonExtInfo(), this.tid);
        }
    }

    public static af copyUserInfo$default(af afVar, String str, String str2, int i3, s35.d dVar, String str3, String str4, a aVar, j25.c cVar, int i16, int i17) {
        List mutableList;
        List mutableList2;
        List mutableList3;
        List mutableList4;
        List mutableList5;
        List mutableList6;
        List mutableList7;
        List mutableList8;
        List mutableList9;
        List mutableList10;
        af afVar2 = (i16 & 1) != 0 ? new af(null, 0L, null, 0, null, 0, null, null, null, null, null, null, null, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, null, null, null, null, false, false, -1, 255) : afVar;
        String str5 = (i16 & 2) != 0 ? afVar2.f433205d : null;
        long j3 = (i16 & 4) != 0 ? afVar2.f433207e : 0L;
        String str6 = (i16 & 8) != 0 ? afVar2.f433209f : str;
        int i18 = (i16 & 16) != 0 ? afVar2.f433212h : 0;
        String str7 = (i16 & 32) != 0 ? afVar2.f433214i : str2;
        int i19 = (i16 & 64) != 0 ? afVar2.f433218m : i3;
        s35.d dVar2 = (i16 & 128) != 0 ? afVar2.C : dVar;
        String str8 = (i16 & 256) != 0 ? afVar2.D : null;
        String str9 = (i16 & 512) != 0 ? afVar2.E : str3;
        String str10 = (i16 & 1024) != 0 ? afVar2.F : str4;
        List<String> list = (i16 & 2048) != 0 ? afVar2.G : null;
        String str11 = (i16 & 4096) != 0 ? afVar2.H : null;
        List<t35.a> list2 = (i16 & 8192) != 0 ? afVar2.I : null;
        List<t35.a> list3 = (i16 & 16384) != 0 ? afVar2.J : null;
        int i26 = (32768 & i16) != 0 ? afVar2.K : 0;
        boolean z16 = (65536 & i16) != 0 ? afVar2.L : false;
        g gVar = (131072 & i16) != 0 ? afVar2.M : null;
        List<String> list4 = (262144 & i16) != 0 ? afVar2.N : null;
        List<String> list5 = (524288 & i16) != 0 ? afVar2.P : null;
        int i27 = (1048576 & i16) != 0 ? afVar2.Q : 0;
        int i28 = (2097152 & i16) != 0 ? afVar2.R : 0;
        List<String> list6 = (4194304 & i16) != 0 ? afVar2.S : null;
        List<s35.e> list7 = (8388608 & i16) != 0 ? afVar2.T : null;
        int i29 = (16777216 & i16) != 0 ? afVar2.U : 0;
        int i36 = (33554432 & i16) != 0 ? afVar2.V : 0;
        int i37 = (67108864 & i16) != 0 ? afVar2.W : 0;
        String str12 = (134217728 & i16) != 0 ? afVar2.X : null;
        ag agVar = (268435456 & i16) != 0 ? afVar2.Y : null;
        r rVar = (536870912 & i16) != 0 ? afVar2.Z : null;
        aa aaVar = (1073741824 & i16) != 0 ? afVar2.f433202a0 : null;
        int i38 = (i16 & Integer.MIN_VALUE) != 0 ? afVar2.f433203b0 : 0;
        String str13 = (i17 & 1) != 0 ? afVar2.f433204c0 : null;
        a aVar2 = (i17 & 2) != 0 ? afVar2.f433206d0 : aVar;
        j25.c cVar2 = (i17 & 4) != 0 ? afVar2.f433208e0 : cVar;
        List<b> list8 = (i17 & 8) != 0 ? afVar2.f433210f0 : null;
        List<t35.a> list9 = (i17 & 16) != 0 ? afVar2.f433211g0 : null;
        List<t35.a> list10 = (i17 & 32) != 0 ? afVar2.f433213h0 : null;
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) list);
        mutableList2 = CollectionsKt___CollectionsKt.toMutableList((Collection) list2);
        mutableList3 = CollectionsKt___CollectionsKt.toMutableList((Collection) list3);
        mutableList4 = CollectionsKt___CollectionsKt.toMutableList((Collection) list4);
        mutableList5 = CollectionsKt___CollectionsKt.toMutableList((Collection) list5);
        mutableList6 = CollectionsKt___CollectionsKt.toMutableList((Collection) list6);
        mutableList7 = CollectionsKt___CollectionsKt.toMutableList((Collection) list7);
        mutableList8 = CollectionsKt___CollectionsKt.toMutableList((Collection) list8);
        mutableList9 = CollectionsKt___CollectionsKt.toMutableList((Collection) list9);
        mutableList10 = CollectionsKt___CollectionsKt.toMutableList((Collection) list10);
        return new af(str5, j3, str6, i18, str7, i19, dVar2, str8, str9, str10, mutableList, str11, mutableList2, mutableList3, i26, z16, gVar, mutableList4, mutableList5, i27, i28, mutableList6, mutableList7, i29, i36, i37, str12, agVar, rVar, aaVar, i38, str13, aVar2, cVar2, mutableList8, mutableList9, mutableList10, false, false, 0, 224);
    }

    public static /* synthetic */ void fetchUserInfo$default(int i3, int i16, String str, Function1 function1, Function2 function2) {
        List<Integer> emptyList;
        NBPNewHomeRepository nBPNewHomeRepository = INSTANCE;
        emptyList = CollectionsKt__CollectionsKt.emptyList();
        nBPNewHomeRepository.fetchUserInfo(i3, i16, str, emptyList, function1, function2);
    }

    public final List<TagInfo> decodeTags(com.tencent.kuikly.core.nvi.serialization.json.b bVar) {
        Object d16;
        ArrayList arrayList = new ArrayList();
        if (bVar != null) {
            int c16 = bVar.c();
            for (int i3 = 0; i3 < c16; i3++) {
                if (BooleanCompanionObject.INSTANCE instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    d16 = Boolean.valueOf(bVar.e(i3));
                } else if (IntCompanionObject.INSTANCE instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    d16 = Integer.valueOf(bVar.i(i3));
                } else if (LongCompanionObject.INSTANCE instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    d16 = Long.valueOf(bVar.m(i3));
                } else if (StringCompanionObject.INSTANCE instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    d16 = bVar.o(i3);
                } else if (DoubleCompanionObject.INSTANCE instanceof com.tencent.kuikly.core.nvi.serialization.json.e) {
                    d16 = Double.valueOf(bVar.g(i3));
                } else {
                    d16 = bVar.d(i3);
                }
                if (d16 != null) {
                    com.tencent.kuikly.core.nvi.serialization.json.e eVar = (com.tencent.kuikly.core.nvi.serialization.json.e) d16;
                    arrayList.add(new TagInfo(new t35.a(eVar.j("tagId"), eVar.p("tagName"), 60)));
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type com.tencent.kuikly.core.nvi.serialization.json.JSONObject");
                }
            }
        }
        return arrayList;
    }

    public final void fetchUserInfo(final int i3, final int i16, final String str, List<Integer> list, final Function1<? super af, Unit> function1, final Function2<? super Integer, ? super String, Unit> function2) {
        List mutableListOf;
        List mutableList;
        List<Integer> listOf = list.isEmpty() ? CollectionsKt__CollectionsKt.listOf((Object[]) new Integer[]{31, 1, 2, 7, 3, 18, 6, 9, 11, 28, 32, 34, 35, 36}) : list;
        mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(str);
        mutableList = CollectionsKt___CollectionsKt.toMutableList((Collection) listOf);
        s35.b bVar = new s35.b(mutableListOf, i16, mutableList, 1, ZPlanVersion.ZPlanVersion);
        Function1<PbResponse<u35.b>, Unit> function12 = new Function1<PbResponse<u35.b>, Unit>() { // from class: com.tencent.hippykotlin.demo.pages.nearby.new_homepage.repository.NBPNewHomeRepository$fetchUserInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Unit invoke(PbResponse<u35.b> pbResponse) {
                Object first;
                PbResponse<u35.b> pbResponse2 = pbResponse;
                KLog kLog = KLog.INSTANCE;
                StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("fetchUserInfo: appId:");
                m3.append(i3);
                m3.append(", accountType:");
                m3.append(i16);
                m3.append(", accountId:");
                m3.append(str);
                m3.append(", proxy retcode:");
                m3.append(pbResponse2.code);
                m3.append(" rsp return code:");
                u35.b bVar2 = pbResponse2.rsp;
                NBPArticleFeedDetailPageV2$$ExternalSyntheticOutline0.m(m3, bVar2 != null ? Integer.valueOf(bVar2.f438201d) : null, kLog, "NBPNewHomeRepository");
                if (pbResponse2.success && pbResponse2.rsp != null) {
                    try {
                        s35.c cVar = new s35.c(0, null, null, 7, null);
                        u35.b bVar3 = pbResponse2.rsp;
                        Intrinsics.checkNotNull(bVar3, "null cannot be cast to non-null type kuikly.com.tencent.trpcprotocol.qqstranger.common_proxy.common_proxy.ProxyRsp");
                        first = CollectionsKt___CollectionsKt.first((List<? extends Object>) ((s35.c) i.b(cVar, bVar3.f438203f.f30291a)).f433228f);
                        af afVar = (af) first;
                        function1.invoke(afVar);
                        NBPNewHomeRepository.access$saveUserInfoByte(i3, str, afVar);
                        NBPNewHomeRepository.access$updateNBPNTGuestUserInfo(i3, str, afVar);
                    } catch (Throwable th5) {
                        AdelieKuiklyHomePageModule$$ExternalSyntheticOutline0.m("fetchUserInfo decode error: ", th5, KLog.INSTANCE, "NBPNewHomeRepository");
                        function2.invoke(Integer.valueOf(pbResponse2.code), th5.toString());
                    }
                } else {
                    function2.invoke(Integer.valueOf(pbResponse2.code), "");
                }
                return Unit.INSTANCE;
            }
        };
        QQStrangerSsoRequest qQStrangerSsoRequest = new QQStrangerSsoRequest(new u35.a("QQStranger.UserInfo", "SsoBatchGetUserInfo", i3, new c45.a(i.d(bVar))));
        QQStrangerSsoService$sendProxyRequest$1 qQStrangerSsoService$sendProxyRequest$1 = new QQStrangerSsoService$sendProxyRequest$1(function12);
        APICallTechReporter aPICallTechReporter = new APICallTechReporter(1, "trpc.qqstranger.common_proxy.CommonProxy.SsoHandle");
        QQKuiklyPlatformApi.Companion companion = QQKuiklyPlatformApi.Companion;
        NBPArticleFeedItemView$body$1$3$8$1$2$1$$ExternalSyntheticOutline0.m(aPICallTechReporter, qQStrangerSsoService$sendProxyRequest$1, qQStrangerSsoRequest, null, 6);
    }

    public final String getCachedKey(int i3, String str) {
        return "SelfUserInfoByteArray_" + i3 + util.base64_pad_url + str;
    }

    public static final void access$updateNBPNTGuestUserInfo(int i3, String str, af afVar) {
        if (i3 == 2 && !Intrinsics.areEqual(String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid), str)) {
            QQNearbyModule companion = QQNearbyModule.Companion.getInstance();
            String str2 = afVar.f433209f;
            String str3 = afVar.E;
            companion.getClass();
            com.tencent.kuikly.core.nvi.serialization.json.e eVar = new com.tencent.kuikly.core.nvi.serialization.json.e();
            eVar.v("key_peerId", str);
            eVar.v("nick", str2);
            eVar.v(PhotoCategorySummaryInfo.AVATAR_URL, str3);
            Unit unit = Unit.INSTANCE;
            companion.asyncToNativeMethod("updateNTUserInfo", eVar, (Function1<? super com.tencent.kuikly.core.nvi.serialization.json.e, Unit>) null);
        }
    }

    public static final void access$saveUserInfoByte(int i3, String str, af afVar) {
        String valueOf;
        NBPNewHomeRepository nBPNewHomeRepository = INSTANCE;
        if (i3 == 1) {
            valueOf = QQNearbyModule.Companion.getInstance().getKLUserSelfInfo().userId;
        } else {
            valueOf = String.valueOf(UserDataManager.INSTANCE.getUserSelfInfo().tid);
        }
        if (Intrinsics.areEqual(valueOf, str)) {
            s35.d dVar = afVar.C;
            s35.d dVar2 = dVar != null ? new s35.d(dVar.f433229d, dVar.f433230e, dVar.f433231f) : null;
            String str2 = afVar.E;
            int i16 = afVar.f433218m;
            af afVar2 = new af(null, 0L, afVar.f433209f, 0, afVar.f433214i, i16, dVar2, null, str2, afVar.F, null, null, afVar.I, null, 0, false, null, null, null, 0, 0, null, null, 0, 0, 0, null, null, null, null, 0, null, null, afVar.f433208e0, null, null, null, false, false, -4981, 253);
            MemoryCacheModule memoryCacheModule = (MemoryCacheModule) com.tencent.kuikly.core.manager.c.f117352a.g().acquireModule("KRMemoryCacheModule");
            NearbyConst nearbyConst = NearbyConst.INSTANCE;
            memoryCacheModule.d("nearbypro", nBPNewHomeRepository.getCachedKey(i3, str), i.d(afVar2));
        }
    }
}
