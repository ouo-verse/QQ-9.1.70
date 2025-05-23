package com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center;

import c45.a;
import c45.i;
import com.tencent.hippykotlin.demo.pages.activity.blind_box.jiguangshang.view.BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2;
import com.tencent.hippykotlin.demo.pages.adelie.common.kuikly.util.RequestKt;
import com.tencent.hippykotlin.demo.pages.adelie.module.AdelieKuiklyBaseModule;
import com.tencent.hippykotlin.demo.pages.adelie.page.compose.category_home.module.AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1;
import com.tencent.hippykotlin.demo.pages.foundation.module.OIDBResponse;
import com.tencent.kuikly.core.log.KLog;
import com.tencent.kuikly.core.manager.c;
import com.tencent.kuikly.core.module.e;
import com.tencent.kuikly.core.pager.h;
import defpackage.k;
import h25.ae;
import h25.af;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Ref;

/* compiled from: P */
/* loaded from: classes31.dex */
public final class AdelieCreativeCenterDataManager {
    public static final AdelieCreativeCenterDataManager INSTANCE = new AdelieCreativeCenterDataManager();
    public static final Lazy adelieKuiklyBaseModule$delegate;
    public static String managerSchemeConfig;

    static {
        Lazy lazy;
        lazy = LazyKt__LazyJVMKt.lazy(new Function0<AdelieKuiklyBaseModule>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager$adelieKuiklyBaseModule$2
            @Override // kotlin.jvm.functions.Function0
            public final AdelieKuiklyBaseModule invoke() {
                return (AdelieKuiklyBaseModule) c.f117352a.g().acquireModule("AdelieKuiklyBaseModule");
            }
        });
        adelieKuiklyBaseModule$delegate = lazy;
        managerSchemeConfig = "mqqapi://kuikly/open?local_bundle_name=nearbypro&version=1&src_type=web&use_host_display_metrics=1";
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:17:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final Object fetchCreativeCenterServerData$qecommerce_biz_release(final a aVar, final String str, boolean z16, Continuation<? super OIDBResponse<af>> continuation) {
        AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1 adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1;
        Object coroutine_suspended;
        int i3;
        Ref.ObjectRef objectRef;
        byte[] bArr;
        c cVar;
        af afVar;
        if (continuation instanceof AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1) {
            adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1 = (AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1) continuation;
            int i16 = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.label;
            if ((i16 & Integer.MIN_VALUE) != 0) {
                adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.label = i16 - Integer.MIN_VALUE;
                Object obj = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.result;
                coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                i3 = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.label;
                if (i3 != 0) {
                    ResultKt.throwOnFailure(obj);
                    final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                    Function0<ae> function0 = new Function0<ae>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$rsp$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(0);
                        }

                        @Override // kotlin.jvm.functions.Function0
                        public final ae invoke() {
                            return new ae(a.this, str, 0, 4, null);
                        }
                    };
                    Function1<byte[], af> function1 = new Function1<byte[], af>() { // from class: com.tencent.hippykotlin.demo.pages.adelie.page.compose.creative_center.AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$rsp$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        /* JADX WARN: Type inference failed for: r14v1, types: [T, byte[]] */
                        @Override // kotlin.jvm.functions.Function1
                        public final af invoke(byte[] bArr2) {
                            byte[] bArr3 = bArr2;
                            objectRef2.element = bArr3;
                            return (af) i.b(new af(null, null, null, null, false, null, false, null, null, 511, null), bArr3);
                        }
                    };
                    adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.L$0 = objectRef2;
                    adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.Z$0 = z16;
                    adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.label = 1;
                    Object sendOIDBRequest = RequestKt.sendOIDBRequest(1, 37340, function0, function1, adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1);
                    if (sendOIDBRequest == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    obj = sendOIDBRequest;
                    objectRef = objectRef2;
                } else if (i3 == 1) {
                    z16 = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.Z$0;
                    objectRef = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.L$0;
                    ResultKt.throwOnFailure(obj);
                } else {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                OIDBResponse oIDBResponse = (OIDBResponse) obj;
                bArr = (byte[]) objectRef.element;
                if (bArr != null && oIDBResponse.success && !z16) {
                    cVar = c.f117352a;
                    if (!k.a(cVar)) {
                        AdelieCreativeCenterDataManager adelieCreativeCenterDataManager = INSTANCE;
                        KLog kLog = KLog.INSTANCE;
                        kLog.i("AdelieCreativeCenterDataManager", "saveCreativeCenterCacheDataByteArray start");
                        AdelieKuiklyBaseModule adelieKuiklyBaseModule = adelieCreativeCenterDataManager.getAdelieKuiklyBaseModule();
                        StringBuilder m3 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("adelie_creative_center");
                        m3.append(cVar.g().getPageData().n().q("uin", ""));
                        String sb5 = m3.toString();
                        adelieKuiklyBaseModule.getClass();
                        ((e) h.a().acquireModule("KRDiskCacheModule")).e(sb5, bArr);
                        kLog.i("AdelieCreativeCenterDataManager", "saveCreativeCenterCacheDataByteArray end");
                    } else if (AdelieKuiklyHomePageModule$$ExternalSyntheticOutline1.m(cVar) && (afVar = (af) oIDBResponse.rsp) != null) {
                        AdelieCreativeCenterDataManager adelieCreativeCenterDataManager2 = INSTANCE;
                        KLog kLog2 = KLog.INSTANCE;
                        kLog2.i("AdelieCreativeCenterDataManager", "saveCreativeCenterCacheDataStringCache start");
                        AdelieKuiklyBaseModule adelieKuiklyBaseModule2 = adelieCreativeCenterDataManager2.getAdelieKuiklyBaseModule();
                        StringBuilder m16 = BlindBoxOperationBottomBarButton$$ExternalSyntheticOutline2.m("adelie_creative_center");
                        m16.append(cVar.g().getPageData().n().q("uin", ""));
                        String sb6 = m16.toString();
                        String c16 = i.c(afVar);
                        int i17 = AdelieKuiklyBaseModule.$r8$clinit;
                        adelieKuiklyBaseModule2.setStringToCache$enumunboxing$(sb6, c16, 1, 1);
                        kLog2.i("AdelieCreativeCenterDataManager", "saveCreativeCenterCacheDataStringCache end");
                    }
                }
                return oIDBResponse;
            }
        }
        adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1 = new AdelieCreativeCenterDataManager$fetchCreativeCenterServerData$1(this, continuation);
        Object obj2 = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.result;
        coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        i3 = adelieCreativeCenterDataManager$fetchCreativeCenterServerData$1.label;
        if (i3 != 0) {
        }
        OIDBResponse oIDBResponse2 = (OIDBResponse) obj2;
        bArr = (byte[]) objectRef.element;
        if (bArr != null) {
            cVar = c.f117352a;
            if (!k.a(cVar)) {
            }
        }
        return oIDBResponse2;
    }

    public final AdelieKuiklyBaseModule getAdelieKuiklyBaseModule() {
        return (AdelieKuiklyBaseModule) adelieKuiklyBaseModule$delegate.getValue();
    }
}
